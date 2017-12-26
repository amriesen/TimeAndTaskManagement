package model;

import java.time.LocalDateTime;

/**
 * An object to encapsulate a status update which can be attached to a ToDoTask to create a record of updates to the task.
 * @author anthonyriesen
 *
 */
public class TaskLog {
	
	private LocalDateTime dateTime;
	private String content;
	
	/**
	 * Constructor that creates an update.  Time stamp is added automatically.
	 * @param content A short description of changes to a task.
	 */
	public TaskLog(String content) {
		this.setDateTime(LocalDateTime.now());
		this.setContent(content);
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
