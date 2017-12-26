package model;

import java.time.LocalDateTime;

/**
 * Definition of the record for a given work day for tracking time spent
 * @author anthonyriesen
 *
 */

public class VisitRecord {

	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	
	/**
	 * Constructor that initializes the work day object.
	 */
	public VisitRecord() {
		this.setStartTime(LocalDateTime.now());
		this.setEndTime(null);
	}
	
	/**
	 * Method that performs operations that terminate the work day. This includes recording the end time and date and calculating time spent.
	 */
	public void endWork() {
		this.setEndTime(LocalDateTime.now());
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime localDateTime) {
		this.startTime = localDateTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
}

