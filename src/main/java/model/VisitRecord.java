package model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Definition of the record for a given work day for tracking time spent
 * 
 * @author anthonyriesen
 *
 */

@Entity
public class VisitRecord {

	private Timestamp startTime;
	private Timestamp endTime;

	@Id
	@GeneratedValue
	private long id;

	/**
	 * Constructor that initializes the work day object.
	 */
	public VisitRecord() {
		this.setStartTime(Timestamp.valueOf(LocalDateTime.now()));
		this.setEndTime(null);
	}

	/**
	 * Method that performs operations that terminate the work day. This includes
	 * recording the end time and date and calculating time spent.
	 */
	public void endWork() {
		this.setEndTime(Timestamp.valueOf(LocalDateTime.now()));
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp localDateTime) {
		this.startTime = localDateTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}
