package edu.hawaii.ics466;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Sets the current Display in the Info tab
 * 
 * @author Ardell Klemme
 *
 */
public class PublicAssaultActivity extends ExpandableListActivity {
  
  ExpandableListAdapter mAdapter;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    mAdapter = new MyExpandableListAdapter();
    setListAdapter(mAdapter);
    registerForContextMenu(getExpandableListView());
  }
  
  @Override
  public boolean onContextItemSelected(MenuItem item) {
      ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo) item.getMenuInfo();

      String title = ((TextView) info.targetView).getText().toString();

      int type = ExpandableListView.getPackedPositionType(info.packedPosition);
      if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
          int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition); 
          int childPos = ExpandableListView.getPackedPositionChild(info.packedPosition); 
          Toast.makeText(this, title + ": Child " + childPos + " clicked in group " + groupPos,
                  Toast.LENGTH_SHORT).show();
          return true;
      } else if (type == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
          int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition); 
          Toast.makeText(this, title + ": Group " + groupPos + " clicked", Toast.LENGTH_SHORT).show();
          return true;
      }

      return false;
  }
  
  /**
   * A simple adapter which maintains an ArrayList of photo resource Ids. 
   * Each photo is displayed as an image. This adapter supports clearing the
   * list of photos and adding a new photo.
   *
   */
  public class MyExpandableListAdapter extends BaseExpandableListAdapter {
      // Sample data set.  children[i] contains the children (String[]) for groups[i].
    private String [] groups = {
        "1. Call the authorities now.",
        "2. Don't be a hero.",
        "3. Be smart.",
        "4. Only assist with the help of others.",
        "5. Protect yourself legally.",
        "6. Administer aid."
    };
    private String[][] children = {
        {"step1", "step2", "step3"},
        {"step1", "step2"}
    };

      public Object getChild(int groupPosition, int childPosition) {
          return children[groupPosition][childPosition];
      }

      public long getChildId(int groupPosition, int childPosition) {
          return childPosition;
      }

      public int getChildrenCount(int groupPosition) {
          return children[groupPosition].length;
      }

      public TextView getGenericView() {
          // Layout parameters for the ExpandableListView
          AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                  ViewGroup.LayoutParams.MATCH_PARENT, 64);

          TextView textView = new TextView(PublicAssaultActivity.this);
          textView.setLayoutParams(lp);
          // Center the text vertically
          textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
          // Set the text starting position
          textView.setPadding(36, 0, 0, 0);
          return textView;
      }

      public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
              View convertView, ViewGroup parent) {
          TextView textView = getGenericView();
          textView.setText(getChild(groupPosition, childPosition).toString());
          return textView;
      }

      public Object getGroup(int groupPosition) {
          return groups[groupPosition];
      }

      public int getGroupCount() {
          return groups.length;
      }

      public long getGroupId(int groupPosition) {
          return groupPosition;
      }

      public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
              ViewGroup parent) {
          TextView textView = getGenericView();
          textView.setText(getGroup(groupPosition).toString());
          return textView;
      }

      public boolean isChildSelectable(int groupPosition, int childPosition) {
          return true;
      }

      public boolean hasStableIds() {
          return true;
      }

  }


}