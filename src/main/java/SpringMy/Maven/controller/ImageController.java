package SpringMy.Maven.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SpringMy.Maven.Services.DbServices;
import SpringMy.Maven.db.enities.FileDetail;



public class ImageController {
	
	@Autowired
	private DbServices dbServices;
	

	@RequestMapping("/imageDisplay")
	  public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{


		FileDetail item = dbServices.getImageData(itemId);        
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(item.getFile());
	    response.getOutputStream().close();
	}
}
