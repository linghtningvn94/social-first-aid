package edu.hawaii.ics466;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Sets the current Display in the Info tab
 * 
 * @author Sean Chung
 *
 */
public class InfoActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    TextView textview = new TextView(this);
    textview.setText("Info");
    setContentView(textview);
  }
}