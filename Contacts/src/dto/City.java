package dto;

public class City {
	int cityId;
	String cityName;
	public City(){
	this.cityId=0;
	this.cityName="";
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
