package SpringMy.Maven.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import SpringMy.Maven.Services.CommonServices;
import SpringMy.Maven.Services.DbServices;
import SpringMy.Maven.model.FileDTO;
import SpringMy.Maven.model.ResponseDTO;
import SpringMy.Maven.model.UserDTO;

@Controller
@SessionAttributes("userForm")
@EnableWebMvc

public class FileUploadController {
	
	@Autowired
	DbServices dbServices;
	@Autowired
	private CommonServices commonServices;
		
	
	
	
	
	// @RequestMapping(value = "/saveimage")
    /* public String uploadResources(@RequestParam String action, HttpServletRequest servletRequest, HttpServletResponse response, @ModelAttribute("product") FileDTO fileDTO, 
    		 Model model,@ModelAttribute("userForm") UserDTO userDTO) throws IOException{
		 
		if (action.equals("save")) {
			CommonsMultipartFile imagecm = fileDTO.getImages();
			byte[] encoded = Base64.encodeBase64(imagecm.getBytes());
			

			if (dbServices.saveFileData(fileDTO, userDTO)) { 
				dbServices.updatePayStatusOfAUser(userDTO);											
				commonServices.saveFile(userDTO.getUserid() + File.separator + fileDTO.getCatagoryName(), imagecm);
				System.out.println("In upload page="+userDTO.toString()); 
				String encodedString = new String(encoded);
				model.addAttribute("image", encodedString);

				model.addAttribute("sucessMagssage",
						"WELCOME " + userDTO.getLastname().toUpperCase() + " " + userDTO.getFirstname().toUpperCase());
				model.addAttribute("fileDTO", fileDTO);
			} else
				model.addAttribute("fileSizeError", "title should not be same on same catagory");

		

		} else if (action.equals("delete")) {
			System.out.println("CatagoryName="+fileDTO.getCatagoryName()+" ,PositionName="+fileDTO.getPositionName());
			model.addAttribute("sucessMagssage",
					"WELCOME " + userDTO.getLastname().toUpperCase() + " " + userDTO.getFirstname().toUpperCase());
			
			FileDTO totalFileData = dbServices.deleteFileData(fileDTO, userDTO);//delete file 
			dbServices.updatePayStatusOfAUser(userDTO);	
			
		}
		
		model.addAttribute("product", new FileDTO());
		model.addAttribute("paymentDetail", new PaymentDTO());
		HashMap<String, LinkedList<DisplayFileDTO>> displayFileDTOMap = dbServices.getDisplayFileData(userDTO);

		if (displayFileDTOMap.size() > 0) {
			for (Map.Entry<String, LinkedList<DisplayFileDTO>> entry : displayFileDTOMap.entrySet()) {
                 String k = entry.getKey();
                 LinkedList<DisplayFileDTO> v = entry.getValue();                  
                 for(DisplayFileDTO dfdto : v){
                	 byte[] encoded=Base64.encodeBase64( dfdto.getItemImage());
                	 String encodedString = new String(encoded);
                	 model.addAttribute("image_"+dfdto.getPosition(), encodedString);
                	 model.addAttribute("titel_"+dfdto.getPosition(), dfdto.getTitel());
                    }
			}
						
			model.addAttribute("size", "");
			     
		}else{
			   model.addAttribute("size", "0");
		     }
         
		 return "registrationsuccess";
		 
	     }*/
	
	
	 @RequestMapping(value = "/json/saveimage")
     public @ResponseBody ResponseDTO uploadResourcesJson(@RequestParam String action, HttpServletRequest servletRequest, 
    		                                         HttpServletResponse response, @ModelAttribute("product") FileDTO fileDTO, 
    		                                         Model model,@ModelAttribute("userForm") UserDTO userDTO) throws IOException{
		 
		 ResponseDTO responseDTO = new ResponseDTO();
		 
		if (action.equals("save")) {
			CommonsMultipartFile imagecm = fileDTO.getImages();
			if(fileDTO.getTitel().trim().length()>1 && fileDTO.getTitel().trim().length()<70) {
				Integer fileid = dbServices.saveFileData(fileDTO, userDTO);
			   if (fileid!=0) { 
				   dbServices.updatePayStatusOfAUser(userDTO);	
				   responseDTO.setSuccess(true);
				   responseDTO.setMessage("file upload is successful");
				   fileDTO.setFileId(fileid);
				   responseDTO.setData(fileDTO);
				   
				   //commonServices.saveFile(userDTO.getUserid() + File.separator + fileDTO.getCatagoryName(), imagecm);				
			       } else {
			    	        responseDTO.setSuccess(false); 
			    	        responseDTO.setMessage("title should not be same on same catagory");
				            //return "title should not be same on same catagory";
			              }
			        //return "file upload is successful";
				
		         }
		      else if(fileDTO.getTitel()==null) {
		    	      responseDTO.setSuccess(false); 
	    	          responseDTO.setMessage("Kindly enter a valid title");
			          //return "Kindly enter a valid title";
		             }
		      else if(fileDTO.getTitel().trim().length()>70) {
			          //return "enter title within 50 chareactere"; 
		    	      responseDTO.setSuccess(false); 
    	              responseDTO.setMessage("enter title within 50 chareactere");
		             }
	         }
		return responseDTO;
	 } 
	 @RequestMapping(value = "/json/deleteimage", headers = {"Accept=text/xml, application/json"}, produces = "application/json")
     public @ResponseBody ResponseDTO deleteResourcesJson(@RequestParam String action, HttpServletRequest servletRequest, 
    		                                         HttpServletResponse response, @ModelAttribute("product") FileDTO fileDTO, 
    		                                         Model model,@ModelAttribute("userForm") UserDTO userDTO) throws IOException{
		 
		 ResponseDTO responseDTO = new ResponseDTO();
		 
		 if (action.equals("delete")) {
			
			String  totalFileData = dbServices.deleteFileData(fileDTO);//delete file				
			dbServices.updatePayStatusOfAUser(userDTO);	
			responseDTO.setSuccess(true);
			responseDTO.setMessage(totalFileData);
				
			}
		 
		 return responseDTO;	
	 }
	 
	 
	 
	 
	 
	/* @RequestMapping(value = "/json/deleteimage", headers = {"Accept=text/xml, application/json"}, produces = "application/json")
     public @ResponseBody FileDTO deleteResourcesJson(@RequestParam String action, HttpServletRequest servletRequest, 
    		                                         HttpServletResponse response, @ModelAttribute("product") FileDTO fileDTO, 
    		                                         Model model,@ModelAttribute("userForm") UserDTO userDTO) throws IOException{
		 FileDTO totalFileData = null;
		 if (action.equals("delete")) {
			 //System.out.println("fileDTO="+fileDTO.toString());
			 totalFileData = dbServices.deleteFileData(fileDTO, userDTO);//delete file
				
				
				dbServices.updatePayStatusOfAUser(userDTO);	
				//System.out.println("totalFileData="+totalFileData);
				return totalFileData;
			}else
				 return new FileDTO();
		 
				
	 }*/
}


//http://stackoverflow.com/questions/20193138/very-simple-spring-mvc-button-click