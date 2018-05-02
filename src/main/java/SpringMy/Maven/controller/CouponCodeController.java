package SpringMy.Maven.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import SpringMy.Maven.Services.CommonServices;
import SpringMy.Maven.Services.DbServices;
import SpringMy.Maven.model.CouponCode;
import SpringMy.Maven.model.UserDTO;



@Controller
@SessionAttributes({"userForm", "clubDataList"})
@EnableWebMvc
public class CouponCodeController {
	
	@Autowired
	CommonServices 	commonServices;
	@Autowired
	private DbServices dbServices;
	
	@RequestMapping("/createCoupon")
	public String createCouponCode(@RequestParam String action, Model model, 
			@ModelAttribute("couponCode") CouponCode couponCodeBean, 
			HttpServletResponse response,
			@ModelAttribute("userForm") UserDTO userDTO,
			@ModelAttribute("clubDataList") List<String> clubDataList, 
			HttpServletRequest request) throws IOException {
		
		 model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "+ userDTO.getFirstname().toUpperCase());
		 if (action.equals("createSigle")) {
		    if(couponCodeBean.getUserId()!=null && couponCodeBean.getPersent()!=null) {	
		    	if( commonServices.checkPersentInpout(couponCodeBean.getPersent().trim())) {
		    		
		    	    if(commonServices.checkNumberOnly(couponCodeBean.getUserId().trim())){
		    	    	System.out.println("I am creating");
		    		    String outPut = dbServices.createSingleCouponeCode(couponCodeBean.getUserId().trim(),couponCodeBean.getPersent().trim(),userDTO.getUserid(),userDTO.getEmail());
		    		    model.addAttribute("couponCodeError",outPut);
		    		   
		    	      }else {
		    	    	      model.addAttribute("couponCodeError","Enter correct userId");
		    	            }
		    	   
		    	  }else {
		    		       
		    		       model.addAttribute("couponCodeError","Enter correct disocount persent");
		    	        }
			   
		      }
		else {
			   model.addAttribute("couponCodeError","Enter a valid data and submit again");
		     }
				
	  }else if (action.equals("createClubCoupon")) {
		        if(couponCodeBean.getClubData()!=null && couponCodeBean.getPersent()!=null) {	
		        	if( commonServices.checkPersentInpout(couponCodeBean.getPersent().trim())) {
		        		if(!couponCodeBean.getClubData().contains(">")) {
		        			model.addAttribute("clubcouponCodeError","Select a valid club name");
		        			model.addAttribute("clubDataList", clubDataList);
		        		  }
		        		else {
		        			  String clubName = couponCodeBean.getClubData().substring(0,couponCodeBean.getClubData().indexOf(" >")).trim();
			        		  System.out.println("clubName="+clubName);
		        		      dbServices.createClubCouponeCode(clubName,couponCodeBean.getPersent().trim(),userDTO.getUserid(),userDTO.getEmail());
		        		      model.addAttribute("clubcouponCodeError","CouponCode Created");
		        		      model.addAttribute("clubDataList", clubDataList);
		        		     }
		        	  }else { 
		        		      model.addAttribute("clubDataList", clubDataList);
		        		      model.addAttribute("clubcouponCodeError","Enter correct disocount persent");
		        	        }
		        	//System.out.println("club="+couponCodeBean.getClubData()+"   "+couponCodeBean.getPersent());
		          }
		  
	           }
		return "admin";
	}
}
