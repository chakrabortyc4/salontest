package SpringMy.Maven.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import SpringMy.Maven.Services.DbServices;
import SpringMy.Maven.Utility.SelectData;
import SpringMy.Maven.model.FileDTO;
import SpringMy.Maven.model.PaymentDTO;
import SpringMy.Maven.model.UserDTO;
import SpringMy.Maven.model.UserStatusDisplayDTO;


@Controller 
@SessionAttributes("userForm")
@EnableWebMvc
public class WelcomeController {
	
	@Autowired
	private DbServices dbServices;
	@Autowired
	SelectData selectData;
	
	@RequestMapping("/")
	 public ModelAndView getWelcomePage() throws IOException {	    		    		        	    	
	        return new ModelAndView("home"); 
	    }  
			
	    @RequestMapping("/home")  
	    public ModelAndView helloWorld() throws IOException {	    		    		        	    	
	        return new ModelAndView("home"); 
	    } 
	    
	    @RequestMapping("/getUserTable")
		public String viewLogin(Map<String, Object> model) throws IOException {
	    	List<UserStatusDisplayDTO> userStatusDisplayDTOList = dbServices.getUserDateForStatusTable();
	    	System.out.println("userStatusDisplayDTOList="+userStatusDisplayDTOList);
			model.put("tableData", userStatusDisplayDTOList);	
			return "table";		
		  }
	 
	 @RequestMapping("/getRegistrationForm") 
	 public String viewRegistration(Map<String, Object> model) throws IOException {
		    UserDTO userForm = new UserDTO(); 
		    model.put("userForm", userForm);	 		    
		    List<String> genderList = selectData.genderData();
		    List<String> countryList = selectData.countryData();
	        model.put("genderList", genderList);
	        model.put("countryList", countryList);	        
	        return "UserRegistration";
	    }

	 @RequestMapping(value="/processRegistration", method = RequestMethod.POST)
	 public String processRegistration(@ModelAttribute("userForm") UserDTO userDTO,  Model model) throws IOException{
		  List<String> usersEmailList=dbServices.getListOfAColumn("email");
		  if(!usersEmailList.contains(userDTO.getEmail())){
		  dbServices.saveUserData(userDTO);
		  dbServices.updatePayStatusOfAUser(userDTO);
		  model.addAttribute("sucessMagssage", "welcome "+userDTO.getLastname()+" " + userDTO.getFirstname());
		  model.addAttribute("product", new FileDTO());
		  model.addAttribute("paymentDetail", new PaymentDTO());
		  model.addAttribute("userForm", userDTO);
	      return "registrationsuccess";
		  }
		  else{
			    model.addAttribute("userForm", userDTO);
			    model.addAttribute("error", "Email Already Exist !   ");
			    List<String> genderList = selectData.genderData();
			    List<String> countryList = selectData.countryData();
		        model.addAttribute("genderList", genderList);
		        model.addAttribute("countryList", countryList);
			    return "UserRegistration";
		      }
	   }
	 
	 
	
	 
	}
