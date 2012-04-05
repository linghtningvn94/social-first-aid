package edu.hawaii.ics466;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Sets the current Display in the Info tab
 * 
 * @author Sean Chung
 *
 */
public class InfoActivity extends ListActivity {
	
  private DatabaseHelper helper;
  private SQLiteDatabase database;
  
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, LOCATIONS));
    
    ListView lv = getListView();
    lv.setTextFilterEnabled(true);
    
    lv.setOnItemClickListener(new OnItemClickListener() {
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), ((TextView) view).getText(), 
            Toast.LENGTH_SHORT).show();
      }
    });

    
    

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
  static final String[] LOCATIONS = new String[] {"Home", "Public", "School", "Work"};
}