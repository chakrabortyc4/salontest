package SpringMy.Maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
//@Scope("session")
@EnableWebMvc
//@RequestMapping(value = "/payment")
public class PaymentCrontroller {
	
	/*@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}*/
		
	
}
	

/*public class PaymentCrontroller {
	
	@Autowired
	private CommonServices commonServices;	
	@Autowired
	private UserDTO userDTO;
	
	public void setCommonService(CommonServices commonService) {
		this.commonServices = commonService;
	}
	
	 @RequestMapping(value = "/payment")
     public void uploadResources(@RequestParam String action, HttpServletRequest servletRequest, 
    		                       HttpServletResponse response, @ModelAttribute("payment") PaymentDTO PaymentDTO, Model model) 
    		                       throws IOException{
		 
		                            System.out.println("I am in payment");
		                            
		                            
		                            
		                			if(commonServices.userIsNative(userDTO))
		                				//java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.google.co.in"));
		                			   model.addAttribute("payurl","https://www.google.co.in");
		                			 else
		                				 //java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.paypal.com/in/home"));
		                				 model.addAttribute("payurl","https://in.yahoo.com/?p=us");
		 
									//return "registrationsuccess";
		 
	 }

}*/
