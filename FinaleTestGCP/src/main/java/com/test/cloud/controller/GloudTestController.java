package com.test.cloud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test.cloud.entity.GcloudTestEntity;
import com.test.cloud.repository.GcloudTestRepository;

@RestController
public class GloudTestController {

	@Autowired
	GcloudTestRepository gcloudTestRepository;

	@Autowired
	GcloudTestEntity gCloudEntity;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
System.out.println("-----reached");
		return new ModelAndView("welcomeIndex");
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(Model model, HttpServletRequest request, HttpSession session,
			@RequestBody String jsonInString) {

		try {
		JSONArray parentJsonArr1 = new JSONArray(jsonInString);
		JSONObject parentJsonObj1 = parentJsonArr1.getJSONObject(0);
		JSONArray parentJsonArr2 = new JSONArray("["+parentJsonObj1.get("user")+"]");
		
		JSONObject parentJsonObj2 = parentJsonArr2.getJSONObject(0);

		gCloudEntity.setUserName("" + parentJsonObj2.get("usrName"));
		gCloudEntity.setUserAddress("" + parentJsonObj2.get("usrAddress"));

		this.gcloudTestRepository.save(gCloudEntity);
		} catch (JSONException e) {    
			
            e.printStackTrace();
            return "{\"status\":\"Invalid request..!\"}";
        }
		return "{\"status\":\"User Added Successfully done\"}";
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public List<GcloudTestEntity> getUser(Model model, HttpServletRequest request, HttpSession session) {
		return this.gcloudTestRepository.findAll();

	}
	@RequestMapping(value = "/deleteAllUser", method = RequestMethod.GET)
	public String deleteAllUser(Model model, HttpServletRequest request, HttpSession session) {
		 this.gcloudTestRepository.deleteAll();
		 return "{\"status\":\"Deleted all the records\"}";

	}
}
