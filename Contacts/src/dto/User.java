package dto;

import java.io.Serializable;

import vo.ColourVO;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int id;
	String userName;
	String passWord;
	String address;
	String phoneNumber;
	City cities;
	Colour colour;

	public Colour getColour() {
		return colour;
	}
	public void setColour(Colour colour) {
		this.colour = colour;
	}
	public City getCities() {
		return cities;
	}
	public void setCities(City cities) {
		this.cities = cities;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
