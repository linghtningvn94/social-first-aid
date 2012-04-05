package edu.hawaii.ics466;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

/**
 * Main Activity, where the app starts, ignore deprecated for now.
 * 
 * @author Sean Chung
 *
 */
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    TabHost tabHost = getTabHost(); 
    
    // Learning tab
    Intent infoIntent = new Intent().setClass(this, InfoActivity.class);
    TabSpec infoTab = tabHost
      .newTabSpec("Info")
      .setIndicator("Info")
      .setContent(infoIntent);

    // Forum tab
    Intent forumIntent = new Intent().setClass(this, ForumActivity.class);
    TabSpec forumTab = tabHost
      .newTabSpec("Forum")
      .setIndicator("Forum")
      .setContent(forumIntent);
    
    // Test tab
    Intent testIntent = new Intent().setClass(this, TestActivity.class);
    TabSpec testTab = tabHost
      .newTabSpec("Test")
      .setIndicator("Test")
      .setContent(testIntent);
    
    // Info tab
    Intent counselIntent = new Intent().setClass(this, CounselActivity.class);
    TabSpec counselTab = tabHost
      .newTabSpec("Cousl")
      .setIndicator("Cousl") 
      .setContent(counselIntent);
    
    // Add all tabs 
    tabHost.addTab(infoTab);
    tabHost.addTab(forumTab);
    tabHost.addTab(testTab);
    tabHost.addTab(counselTab);
    
    // Set the initial selected tab
    tabHost.setCurrentTab(0);
  }
}