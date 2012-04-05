package edu.hawaii.ics466;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Sets the current Display in the Info tab
 * 
 * @author Ardell Klemme
 *
 */
public class HomeActivity extends ListActivity {
    
    TextView selection;
    ListItem[] issues = {
        new ListItem("Alcoholism", PublicAssaultActivity.class),
        new ListItem("Children Who Misbehave", PublicAssaultActivity.class),
        new ListItem("Hostility Between Adults", PublicAssaultActivity.class),
        new ListItem("Depression in Teens", PublicAssaultActivity.class),
        new ListItem("Depression in Adults", PublicAssaultActivity.class),
        new ListItem("Disrespectful Family Member", PublicAssaultActivity.class),
        new ListItem("Rebellious Teens", PublicAssaultActivity.class),
        new ListItem("Physical Abuse", PublicAssaultActivity.class),
        new ListItem("Verbal Abuse", PublicAssaultActivity.class)
    };

    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setListAdapter(new ArrayAdapter<ListItem>(
          this,android.R.layout.simple_list_item_1, issues));
      selection = (TextView) findViewById(R.id.info_location);
    }


    @Override
    protected void onListItemClick(ListView lview, View view, int position, long id) {
      super.onListItemClick(lview, view, position, id);
      final Intent intent = new Intent(this, issues[position].getActivity());
      startActivityForResult(intent, position);
    }
}