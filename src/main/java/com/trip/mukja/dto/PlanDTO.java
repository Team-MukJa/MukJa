package com.trip.mukja.dto;

public class PlanDTO {
	
	
	int content_id;
	String title;
	String addr1;
	String first_image;
	String overview;
	double latitude;
	double longitude;

	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getFirst_image() {
		return first_image;
	}
	public void setFirst_image(String first_image) {
		this.first_image = first_image;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "PlanDto [content_id=" + content_id + ", title=" + title + ", addr1=" + addr1 + ", first_image="
				+ first_image + ", overview=" + overview + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
	
	
	
	
}
