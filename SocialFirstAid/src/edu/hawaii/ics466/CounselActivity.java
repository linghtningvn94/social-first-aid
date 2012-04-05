package edu.hawaii.ics466;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Sets the current display in the Learn tab
 * 
 * @author Sean Chung
 *
 */
public class CounselActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    TextView textview = new TextView(this);
    textview.setText("Find Counselors");
    setContentView(textview);
  }
}