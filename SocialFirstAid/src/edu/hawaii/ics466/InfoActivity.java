package edu.hawaii.ics466;

import java.util.List;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Sets the current Display in the Info tab
 * 
 * @author Sean Chung
 *
 */
public class InfoActivity extends Activity {
	
  private DatabaseHelper helper;
  private SQLiteDatabase database;
  
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    

    TextView textview = new TextView(this);
    String s = "";
    helper = new DatabaseHelper (this);
    database = helper.getReadableDatabase();
    
    List <Content> list = helper.getAllContent(database);
    for(int i = 0; i < list.size(); i++) {
    	s += list.get(i) +"\n";
    }
    
    
    textview.setText(s);
    setContentView(textview);
  }
}