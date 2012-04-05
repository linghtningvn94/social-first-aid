package edu.hawaii.ics466;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

/**
 * Sets the current Display in the Info tab
 * 
 * @author Ardell Klemme
 *
 */
public class WorkActivity extends ListActivity {
  /** Call when we activate activity **/
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    ListAdapter adapter = createAdapter();
    setListAdapter(adapter);
  }

  /**
   * Creates a List adapter for HomeActivity
   * 
   * @return
   */
  private ListAdapter createAdapter() {
    //generate the list of topics for home location
    String[] homeTopics = new String[] {
        "Alcoholism",
        "Children Who Misbehave",
        "Hostility Between Adults",
        "Depression in Teens",
        "Depression in Adults",
        "Disrespectful Family Member",
        "Rebellious Teens",
        "Physical Abuse",
        "Verbal Abuse"
    };
    
    ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, 
        homeTopics);
    
    return adapter;
  }	
}