package edu.hawaii.ics466;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Sets the current display for the Test tab. 
 * 
 * @author Sean Chung
 *
 */
public class TestActivity extends Activity {
  
  private RadioButton correct;
  private Button submit;
  private TextView review;
  
  /** 
   * Initial start for the test page. Default to the first ChildMisbehaving test question.
   */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);    
    setContentView(R.layout.childmistest);
    createTest();
  }

  /**
   * Create a new test based on the current layout.
   * Values in each layout xml file will have different correct answers.
   */
  public void createTest() {
    submit = (Button) findViewById(R.id.Submit);    
    correct = (RadioButton) findViewById(R.id.Correct);
    review = (TextView) findViewById(R.id.Review);
    review.setText("Click the Submit button after selecting your answer.");    
    
    submit.setOnClickListener(new OnClickListener() {   
      @Override
      public void onClick(View v) {
        if (correct.isChecked()) {
          review.setText("Correct!");
        }
        else {
          review.setText("Wrong!");
        }   
      }   
    });
  }
  
  /**
   * Access the layout for the second question
   * @param view View of question 2.
   */
  public void question2(View view) {
    setContentView(R.layout.childmistest2);
    createTest();
  }
}