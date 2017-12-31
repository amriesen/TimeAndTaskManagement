package model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Object structure for organizing relative information for a Tast
 * 
 * @author anthonyriesen
 *
 */
@Entity
public class ToDoTask {
	public enum TaskCatagory {
		TECHNOLOGY, ADMINISTRATIVE, GENERAL;
	}

	public enum TaskPriority {
		LOW, MEDIUM, HIGH, CRITIAL
	}

	private String description;
	private Timestamp creationDate;
	private Timestamp dueDate;
	private TaskCatagory catagory;
	private TaskPriority priority;
	private String details;
	private List<TaskLog> taskLogs = new ArrayList<>();

	@Id
	@GeneratedValue
	private long id;

	/**
	 * Constructor for Task object for data organization
	 * 
	 * @param description
	 *            A string simply describing the task
	 * @param dueDate
	 *            A date object that describes when a task is due
	 * @param catagory
	 *            An enumerate option that fits the task to a category
	 * @param priority
	 *            An enumerate option that categorizes urgency
	 * @param detials
	 *            A string describing the task in more detail.
	 */
	public ToDoTask(String description, Timestamp dueDate, TaskCatagory catagory, TaskPriority priority,
			String details) {

		this.setDescription(description);
		this.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
		this.setDueDate(dueDate);
		this.setCatagory(catagory);
		this.setPriority(priority);
		this.setDetails(details);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public TaskCatagory getCatagory() {
		return catagory;
	}

	public void setCatagory(TaskCatagory catagory) {
		this.catagory = catagory;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<TaskLog> getTaskLogs() {
		return taskLogs;
	}

	public void setTaskLogs(List<TaskLog> taskLogs) {
		this.taskLogs = taskLogs;
	}

	public void addTaskLog(TaskLog taskLog) {
		this.taskLogs.add(taskLog);
	}
	
	@Override
	public String toString() {
		return description;
	}
}
