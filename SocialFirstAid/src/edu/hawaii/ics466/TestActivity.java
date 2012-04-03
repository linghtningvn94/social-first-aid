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
  private TextView review;
  private int question = 2;
  
  /** 
   * Initial start for the test page. 
   */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    listing();
  }
  
  /**
   * Listing of all current tests to take by subject.
   */
  public void listing() {
    setContentView(R.layout.testlisting); 
    Button childMis = (Button) findViewById(R.id.childMis);    
    childMis.setOnClickListener(new OnClickListener() {   
      @Override
      public void onClick(View v) {
        setContentView(R.layout.childmistest);
        createTest();
      }   
    });
  }

  /**
   * Create a new test based on the current layout.
   * Values in each layout xml file will have different correct answers.
   */
  public void createTest() {
    Button submit = (Button) findViewById(R.id.Submit); 
    Button listing = (Button) findViewById(R.id.listing);
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
          String rightAnswer = "Wrong! The correct answer is: " + correct.getText() + ".";
          review.setText(rightAnswer);
        }   
      }   
    });
    
    listing.setOnClickListener(new OnClickListener() {   
      @Override
      public void onClick(View v) {
        listing();
      }   
    });
  }
  
  /**
   * Access the layout for the next question.
   * @param view View of next question.
   */
  public void selectQuestion(View view) {   
    // Random generator = new Random(System.currentTimeMillis());
    // int question = generator.nextInt();
    switch(question) {
      case 2:
        question++;
        setContentView(R.layout.childmistest2);
        createTest();
        break;
        
      case 3:
        question++;
        setContentView(R.layout.childmistest3);
        createTest();
        break;
        
      case 4:
        setContentView(R.layout.childmistest4);
        createTest();
    }
  }
}