package dev.rowand.models;

public class Form {
private int id;
private int reim_id;
private String formDate;
private String formTime;
private String formLocation;
private String description;

private float reimburse_rate;
private float cost;
private String gradingFormat; //Employee should be able to add grade or presentation at a later time
//add a patch request or something to allow for this
private String typeOfEvent;
private String justification;
private String status;



public Form() {}
public Form(int id, int reim_id, String formDate, String formTime, String formLocation, String description,
		float reimburse_rate, float cost, String gradingFormat, String typeOfEvent, String justification, String status) {
	super();
	this.id = id;
	this.reim_id = reim_id;
	this.formDate = formDate;
	this.formTime = formTime;
	this.formLocation = formLocation;
	this.description = description;
	this.reimburse_rate = reimburse_rate;
	this.cost = cost;
	this.gradingFormat = gradingFormat;
	this.typeOfEvent = typeOfEvent;
	this.justification = justification;
	this.setStatus(status);
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFormDate() {
	return formDate;
}
public void setFormDate(String formDate) {
	this.formDate = formDate;
}
public String getFormTime() {
	return formTime;
}
public void setFormTime(String formTime) {
	this.formTime = formTime;
}
public String getFormLocation() {
	return formLocation;
}
public void setFormLocation(String formLocation) {
	this.formLocation = formLocation;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public float getReimburse_rate() {
	return reimburse_rate;
}
public void setReimburse_rate(float reimburse_rate) {
	this.reimburse_rate = reimburse_rate;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public String getGradingFormat() {
	return gradingFormat;
}
public void setGradingFormat(String gradingFormat) {
	this.gradingFormat = gradingFormat;
}
public String getTypeOfEvent() {
	return typeOfEvent;
}
public void setTypeOfEvent(String typeOfEvent) {
	this.typeOfEvent = typeOfEvent;
}
public String getJustification() {
	return justification;
}
public void setJustification(String justification) {
	this.justification = justification;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getReim_id() {
	return reim_id;
}
public void setReim_id(int reim_id) {
	this.reim_id = reim_id;
}



}
