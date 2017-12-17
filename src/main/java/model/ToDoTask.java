package model;

public class ToDoTask {
	private String description;

	/**
	 * Basic Task Class Object for data organization
	 * @param description
	 */
	public ToDoTask(String description) {
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
