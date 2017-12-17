package model;

public class ToDoTask {
	private String description;
	// private datetime dueDate;
	private Boolean noDate;
	// private enum catagory;
	// private enum priority;
	private String details;


	/**
	 * Basic Task Class Object for data organization
	 * @param description A string simply describing the task
	 * @param dueDate A datetime object that describes when a task is due
	 * @param noDate A boolean determining whether a due date is set
	 * @param catagory An enumerate option that fits the task to a category
	 * @param priority An integer that allows
	 * @param detials
	 */
	public ToDoTask(String description, boolean noDate, String details) {
		this.setDescription(description);
		this.setNoDate(noDate);
		this.setDetails(details);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean getNoDate() {
		return noDate;
	}
	
	public void setNoDate(Boolean noDate) {
		this.noDate = noDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
