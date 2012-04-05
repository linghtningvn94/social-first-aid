package edu.hawaii.ics466;

/**
 * @author Ardell Klemme
 * 
 * Handles list items better
 */
public class ListItem {
  private String label;
  private Class<?> activity;
  
  /**
   * Constructor
   * @param label
   * @param activity
   */
  public ListItem (String label, Class<?> activity) {
    super();
    this.label = label;
    this.activity = activity;
  }
  
  /**
   * @return label for list item
   */
  public String getLabel() {
    return label;
  }
  
  /**
   * @param label the label to set for the list item
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * @return activity for list item
   */
  public Class<?> getActivity() {
    return activity;
  }

  /**
   * @param activity the activity to set for the list item
   */
  public void setActivity(Class<?> activity) {
    this.activity = activity;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return this.label;
  }
}
