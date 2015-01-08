package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.ProfileModel;
import model.RegisterModel;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import vo.CityVO;
import vo.ColourVO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.CityDao;
import dao.ColourDao;
import dao.UserDAO;
import dto.City;
import dto.Colour;

public class Register extends ActionSupport implements ModelDriven<RegisterModel>,SessionAware {
	SessionMap<String, Object> sessionMap;
	RegisterModel regMod = new RegisterModel();
	ProfileModel profileData = new ProfileModel();
	UserDAO userDAO = new UserDAO();
	CityDao cityDao = new CityDao();
	ColourDao colourDao = new ColourDao();
	List<CityVO> cityList;
	List<ColourVO> colourList;
	HttpServletRequest request = ServletActionContext.getRequest();
	
	@Override
	public String execute(){
		//Get City List from DB
		cityList = new ArrayList<CityVO>();
		List<City> cityDto;
		cityDto = cityDao.getCityList();
		for (City city : cityDto) {
			CityVO cityModel = new CityVO();
			cityModel.setCityId(city.getCityId());
			cityModel.setCityName(city.getCityName());
			cityList.add(cityModel);
			System.out.println(city.getCityName());
		}
		sessionMap.put("cityList",cityList);
		
		//Get Colour List from DB
		colourList = new ArrayList<ColourVO>();
		List<Colour> colourDto;
		colourDto = colourDao.getColourList();
		for(Colour colour:colourDto){
			ColourVO colourVo = new ColourVO();
			colourVo.setId(colour.getId());
			colourVo.setColourName(colour.getColourName());
			colourList.add(colourVo);
			System.out.println(colour.getColourName());
		}
		sessionMap.put("colourList", colourList);
		System.out.println("#############Register Execute");
		return "success";
	}
	
	public String registerMethod(){
		System.out.println("####registerMethod");
		
		List<CityVO> cityList = (List<CityVO>)sessionMap.get("cityList");
		List<ColourVO> colourList = (List<ColourVO>)sessionMap.get("colourList");
		
		if(userDAO.AddUser(regMod,cityList.get(regMod.getCities()),colourList.get(regMod.getColourId()))){
			request.setAttribute("status", "Registration Successful- Welcome to our Struts Application!");
			profileData.setUsername(regMod.getUsername());
			profileData.setPhonenumber(regMod.getPhonenumber());
			profileData.setAddress(regMod.getAddress());
			sessionMap.put("userObject", profileData);
			return "success";
		}
		else
			return "fail";
	}
	@Override
	public RegisterModel getModel() {
		// TODO Auto-generated method stub
		return regMod;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap =(SessionMap<String, Object>) arg0;
		
	}

}
