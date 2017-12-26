package controllers;

import model.VisitRecord;

public class DropDownController {

	private VisitRecord record;
	
	public DropDownController() {
	}
	
	public void startRecord() {
		this.setRecord(new VisitRecord());
		System.out.println("Record Started");
	}
	
	public void endRecord() {
		this.record.endWork();
		System.out.println("Record Ended");
		System.out.println(record.getEndTime().getMinute()-record.getStartTime().getMinute());
	}

	public VisitRecord getRecord() {
		return record;
	}

	public void setRecord(VisitRecord record) {
		this.record = record;
	}
}
