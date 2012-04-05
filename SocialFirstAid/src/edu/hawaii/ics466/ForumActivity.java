package edu.hawaii.ics466;

import android.app.Activity;
import android.os.Bundle;

/**
 * Sets the current display for the Forum tab
 * 
 * @author Sean Chung
 *
 */
public class ForumActivity extends Activity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.forum);
  }
}