package edu.hawaii.ics466;

import java.text.DecimalFormat;
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
  private Button listing;
  private Button next;
  private TextView review;
  private int question = 2;
  private int correctAnswers;
  private int totalAnswers;
  
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
    question = 2;
    setContentView(R.layout.testlisting); 
    Button childMis = (Button) findViewById(R.id.childMis);
    Button publicTox = (Button) findViewById(R.id.publicTox);
    
    childMis.setOnClickListener(new OnClickListener() {   
      public void onClick(View v) {
        totalAnswers = correctAnswers = 0;
        setContentView(R.layout.childmistest);
        createTest();
      }   
    });
    publicTox.setOnClickListener(new OnClickListener() {   
      @Override
      public void onClick(View v) {
        totalAnswers = correctAnswers = 0;
        setContentView(R.layout.publictoxtest);
        createTest();
      }   
    });
  }

  /**
   * Create a new test based on the current layout.
   * Values in each layout xml file will have different correct answers.
   */
  public void createTest() {
    submit = (Button) findViewById(R.id.Submit); 
    listing = (Button) findViewById(R.id.listing);
    next = (Button) findViewById(R.id.next);
    correct = (RadioButton) findViewById(R.id.Correct);
    review = (TextView) findViewById(R.id.Review);
    
    submit.setText("Submit");
    review.setText("Select answer and click Submit.");    
    next.setEnabled(false);
   
    submit.setOnClickListener(new OnClickListener() {   
      public void onClick(View v) {
        submit.setEnabled(false);
        submit.setText("");
        next.setEnabled(true);
        totalAnswers++;
        
        if (correct.isChecked()) {
          review.setText("Correct!");
          correctAnswers++;
        }
        else if ((question == 6) && (!correct.isChecked())) {
          review.setText("Wrong..... R U Cereal??");
        }
        else {
          String rightAnswer = "Wrong! The correct answer is: " + "\n" + 
                                correct.getText() + ".";
          review.setText(rightAnswer);
        }   
      }   
    });
    
    listing.setOnClickListener(new OnClickListener() {   
      public void onClick(View v) {
        totalAnswers = correctAnswers = 0;
        listing();
      }   
    });
  }
  
  /**
   * Access the layout for the next question.
   * @param view View of next question.
   */
  public void selectQuestionChild(View v) {   
    /** Deprecated until a larger number of questions are created.
     *
     * Random generator = new Random(System.currentTimeMillis());
     * int question = generator.nextInt(51);
     * 
     */
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
        question++;
        setContentView(R.layout.childmistest4);
        createTest();
        break;
        
      case 5:
        question++;
        setContentView(R.layout.childmistest5);
        createTest();
        break;
      case 6:
        outputResults();
    }
  }
  
  /**
   * Select questions for public intoxication.
   * @param v
   */
  public void selectQuestionTox(View v) {
    switch(question) {
    case 2:
      question++;
      setContentView(R.layout.publictoxtest2);
      createTest();
      break;
      
    case 3:
      question++;
      setContentView(R.layout.publictoxtest3);
      createTest();
      break;
      
    case 4:
      question++;
      setContentView(R.layout.publictoxtest4);
      createTest();
      break;
      
    case 5:
      question++;
      setContentView(R.layout.publictoxtest5);
      createTest();
      break;
    case 6:
      outputResults();
    }  
  }
  
  /**
   * Output Results and score of test.
   */
  public void outputResults() {
    setContentView(R.layout.result);
    TextView results = (TextView) findViewById(R.id.Results);
    results.setText(score());
    listing = (Button) findViewById(R.id.listing);
    listing.setOnClickListener(new OnClickListener() {   
      public void onClick(View v) {
        listing();
      }   
    });
  }
  
  /**
   * Calculates score on current test.
   * 
   * @return String output to user.
   */
  public String score() {
    double percentage = ((double)correctAnswers / (double)totalAnswers);
    int wrongAnswers = totalAnswers - correctAnswers;
    String correct = correctAnswers + " correct answers";
    String wrong = wrongAnswers + " wrong answers";
    
    DecimalFormat df = new DecimalFormat("#.##%");
    if (correctAnswers == 1) {
      correct = "1 answer correct";
    }
    else if (correctAnswers == 0) {
      correct = "nothing correct";
    }
    
    if (wrongAnswers == 1) {
      wrong = "1 answer wrong";
    }
    else if(wrongAnswers == 0) {
      wrong = "nothing wrong";
    }
    return "You got " + correct + " and " + wrong + " for a score of " + 
           df.format(percentage) + "\n" + "\n" + recommendation(percentage * 100);
  }
  
  /**
   * Output recommendation to the user if they should take the test again.
   * 
   * @param grade double value of the percent they got correct on the test
   * @return String qualitatively telling the user how they did
   */
  public String recommendation(double grade) {
    
    if (grade < 70.00) {
      return "You should probably take this test again...";
    }
    else if ((grade >= 70.00) && (grade < 85.00)) {
      return "You did OK on this test.";
    }
    else {
      return "You did very well on this test!";
    }
  }
}