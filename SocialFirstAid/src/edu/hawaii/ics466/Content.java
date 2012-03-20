package edu.hawaii.ics466;

/**
 * Content object. 
 * An object that holds the problem and its solution.
 * @author Alexander Cam Liu
 *
 */
public class Content {
	
	private long id;
	private String problem;
	private String solution;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProblem() {
		return problem;
	}
	
	public void setProblem(String problem) {
		this.problem = problem;
	}
	
	public String getSolution() {
		return solution;
	}
	
	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String toString () {
		return this.problem + "\t" + this.solution;
	}
}
