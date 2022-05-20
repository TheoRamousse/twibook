package iut.uca.twibook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
	  
	  @ResponseBody
	  @RequestMapping("/")
	  public String home() {
		  return null;
	    }
}
