package SpringMy.Maven.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import SpringMy.Maven.Services.CommonServices;
import SpringMy.Maven.model.MailRecipientDTO;

@Controller
@EnableWebMvc
public class SendEmailController {
	
	@Autowired
	private CommonServices commonServices;
	
	public void setCommonServices(CommonServices commonServices) {
		this.commonServices = commonServices;
	}

	@RequestMapping("/getContuctUs" )
    public String fetchEmailForm(Map<String, Object> model) {
		MailRecipientDTO mailRecipientform = new MailRecipientDTO();
		model.put("mailRecipientform", mailRecipientform);
	   return "emailForm";		
	}
	
	
	@RequestMapping(value="/processmail", method = RequestMethod.POST)
    public String doSendEmail(@ModelAttribute("sendEmailForm") MailRecipientDTO mailRecipientDTO,Model model) {		  
		   System.out.println(mailRecipientDTO.toString());
		   //commonServices.sendQueryEmail(mailRecipientDTO);
		   model.addAttribute("massage","mail send succesful");
	       return "emailForm";
	    }		
}
