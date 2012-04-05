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
public class PublicActivity extends ListActivity {
    
    TextView selection;
    ListItem[] issues = {
        new ListItem("Ballroom Events", PublicAssaultActivity.class),
        new ListItem("Fundraisers", PublicAssaultActivity.class),
        new ListItem("Public Aggression", PublicAssaultActivity.class),
        new ListItem("Public Assault", PublicAssaultActivity.class),
        new ListItem("Public Harassment", PublicAssaultActivity.class),
        new ListItem("Public Intoxication", PublicAssaultActivity.class),
        new ListItem("Sociopaths in Public", PublicAssaultActivity.class)
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