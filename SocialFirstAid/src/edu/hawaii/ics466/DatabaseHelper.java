package edu.hawaii.ics466;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Create a new database when using the Social First Aid for the first time. 
 * Populate the database with data after clicking the app (At the same time when database is created). 
 * Code inspired by Lars Vogel's tutorial ("http://www.vogella.de/articles/AndroidSQLite/article.html").
 * @author Alexander Cam Liu
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {
	//Database name
	private final static String DATABASE_NAME = "socialProblems.db";
	//Table & columns
	public final static String TABLE_NAME = "Social_Aid";
	public final static String COLUMN_ID = "_id";
	public final static String COLUMN_PROBLEM = "problem";
	public final static String COLUMN_SOLUTION = "solution";
	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_NAME + "( " 
			+ COLUMN_ID + " integer primary key autoincrement, " 
			+ COLUMN_PROBLEM + " text not null, " 
			+ COLUMN_SOLUTION + " text not null" 
			+ ");";
	//Others
	private String[] allColumns = { COLUMN_ID, COLUMN_PROBLEM,
			COLUMN_SOLUTION};
	
	/**
	 * Constructor to find the database
	 * @param context context.
	 */
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 2);
	}
	
	@Override
	/**
	 * Create a new database if database does not exist (for the first time).
	 * Populate the database with data before using it. 
	 */
	public void onCreate(SQLiteDatabase database) {
		//SQL execution (CREATE TABLE).
		database.execSQL(DATABASE_CREATE);
		//HERE WE EXECUTE QUERIES TO POPULATE THE DATA
		addEntry(database, "Alex", "Sean");
		addEntry(database, "Me", "Me");
	}
	
	/**
	 * Upgrade a new database.
	 * Delete the old and populate with new data. 
	 */
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);	
	}
	
	/**
	 * Add a new entry to a specified database. 
	 * Code inspired by Lars Vogel's tutorial ("http://www.vogella.de/articles/AndroidSQLite/article.html").
	 * @param db the database to be used.
	 * @param problem the data for the PROBLEM column.
	 * @param solution the data for the SOLUTION column.
	 * @return a Content object.
	 */
	public Content addEntry(SQLiteDatabase db, String problem, String solution) {
		//Get values in a bundle
		ContentValues values = new ContentValues();
		values.put(DatabaseHelper.COLUMN_PROBLEM, problem);
		values.put(DatabaseHelper.COLUMN_SOLUTION, solution);
		//Insert a new entry to the database with the values put in the bundle
		long insertId = db.insert(DatabaseHelper.TABLE_NAME, null,
				values);
		//Query the entry added
		Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,
				allColumns, DatabaseHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		//Set the values to a Content object and return it
		Content newContent = cursorToContent(cursor);
		cursor.close();
		return newContent;
	}
	
	/**
	 * Get all of the data from the a selected database. 
	 * Code inspired by Lars Vogel's tutorial ("http://www.vogella.de/articles/AndroidSQLite/article.html").
	 * @param db the database to be used.
	 * @return a List of Content objects. 
	 */
	public List<Content> getAllContent(SQLiteDatabase db) {
		List<Content> listContent = new ArrayList<Content>();
		//Query the database returning all data
		//Return a cursor to traverse the data
		Cursor cursor = db.query(DatabaseHelper.TABLE_NAME,
				allColumns, null, null, null, null, null);
		//Set cursor to point at the first entry
		cursor.moveToFirst();
		//Loop through the list of data
		//Add the data to the List<Content>
		while (!cursor.isAfterLast()) {
			Content problem = cursorToContent(cursor);
			listContent.add(problem);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return listContent;
	}
	
	/**
	 * Set the values to a Content Object.
	 * @param cursor a cursor to traverse each value of an entry from a database.
	 * @return the Content object with all the values set. 
	 */
	private Content cursorToContent(Cursor cursor) {
		Content content = new Content();
		//First row : id
		content.setId(cursor.getLong(0));
		//Second row : problem
		content.setProblem(cursor.getString(1));
		//Third row : solution
		content.setSolution(cursor.getString(2));
		return content;
	}
}