package edu.hawaii.ics466;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Sets the current Display in the Info tab
 * 
 * @author Sean Chung, Ardell Klemme
 *
 */
public class InfoActivity extends ListActivity {

  //  private DatabaseHelper helper;
  //  private SQLiteDatabase database;

  TextView selection;
  ListItem[] locations = {
      new ListItem("Home", HomeActivity.class),
      new ListItem("Public", PublicActivity.class),
      new ListItem("School", SchoolActivity.class),
      new ListItem("Work", WorkActivity.class)
  };

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setListAdapter(new ArrayAdapter<ListItem>(
        this,android.R.layout.simple_list_item_1, locations));
    selection = (TextView) findViewById(R.id.info_location);
  }


  @Override
  protected void onListItemClick(ListView lview, View view, int position, long id) {
    super.onListItemClick(lview, view, position, id);
    final Intent intent = new Intent(this, locations[position].getActivity());
    startActivityForResult(intent, position);
  }
  
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    if (resultCode == RESULT_OK) {
      switch (requestCode) {
      case 0:
        // TODO: handle return of HomeActivity
        break;
      case 1:
        // TODO: handle return of PublicActivity
        break;
      case 2:
        // TODO: handle return of SchoolActivity
        break;
      case 3:
        // TODO: handle return of WorkActivity
        break;
      default:
        break;
      }
    }
    else if (resultCode == RESULT_CANCELED) {
      // TODO: handle cancelation
    }
      
  }

  //    TextView textview = new TextView(this);
  //    String s = "";
  //    helper = new DatabaseHelper (this);
  //    database = helper.getReadableDatabase();
  //    
  //    List <Content> list = helper.getAllContent(database);
  //    for(int i = 0; i < list.size(); i++) {
  //    	s += list.get(i) +"\n";
  //    }
  //    
  //    
  //    textview.setText(s);
  //    setContentView(textview);
}