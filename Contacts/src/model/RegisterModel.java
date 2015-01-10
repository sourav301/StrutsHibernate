package model;

import java.util.List;

import vo.CityVO;
import vo.ColourVO;


public class RegisterModel {
	int id;
	String Username;
	String Password;
	String Address;
	String Phonenumber;
	int cities;
	int colourId;
	List<CityVO> cityList;
	List<ColourVO> colourList;
	
	public List<CityVO> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityVO> cityList) {
		this.cityList = cityList;
	}
	public List<ColourVO> getColourList() {
		return colourList;
	}
	public void setColourList(List<ColourVO> colourList) {
		this.colourList = colourList;
	}
	public int getCities() {
		return cities;
	}
	public void setCities(int cities) {
		this.cities = cities;
	}
	public int getId() {
		return id;
	}
	public int getColourId() {
		return colourId;
	}
	public void setColourId(int colourId) {
		this.colourId = colourId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}
	
}
