package com.trip.mukja.dto;

public class SearchDTO {

	//위도 
	double latitude;
	// 경도 
	double longitude;

	// 이미지
	String first_img;
	// 제목
	String title;
	// 주소  1
	String addr1;
	// 주소 2
	String addr2;
	
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
	public String getFirst_img() {
		return first_img;
	}
	public void setFirst_img(String first_img) {
		this.first_img = first_img;
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
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	@Override
	public String toString() {
		return "SearchDTO [latitude=" + latitude + ", longitude=" + longitude + ", first_img=" + first_img + ", title="
				+ title + ", addr1=" + addr1 + ", addr2=" + addr2 + "]";
	}
	
	
	
}
