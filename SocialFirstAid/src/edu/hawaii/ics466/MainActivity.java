package edu.hawaii.ics466;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
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

    Resources ressources = getResources(); 
    TabHost tabHost = getTabHost(); 
    
    // Learning tab
    Intent learnIntent = new Intent().setClass(this, LearnActivity.class);
    TabSpec learnTab = tabHost
      .newTabSpec("Learn")
      .setIndicator("Learn", ressources.getDrawable(R.drawable.learn_select))
      .setContent(learnIntent);

    // Prep tab
    Intent prepIntent = new Intent().setClass(this, PrepareActivity.class);
    TabSpec prepTab = tabHost
      .newTabSpec("Prep")
      .setIndicator("Prep", ressources.getDrawable(R.drawable.prep_select))
      .setContent(prepIntent);
    
    // Test tab
    Intent testIntent = new Intent().setClass(this, TestActivity.class);
    TabSpec testTab = tabHost
      .newTabSpec("Test")
      .setIndicator("Test")
      .setContent(testIntent);
    
    // Info tab
    Intent infoIntent = new Intent().setClass(this, InfoActivity.class);
    TabSpec infoTab = tabHost
      .newTabSpec("Info")
      .setIndicator("Info") 
      .setContent(infoIntent);
    
    // Add all tabs 
    tabHost.addTab(learnTab);
    tabHost.addTab(prepTab);
    tabHost.addTab(testTab);
    tabHost.addTab(infoTab);
    
    // Set the initial selected tab
    tabHost.setCurrentTab(0);
  }
}