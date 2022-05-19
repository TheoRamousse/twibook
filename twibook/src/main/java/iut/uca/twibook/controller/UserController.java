package iut.uca.twibook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import iut.uca.twibook.service.interfaces.IUserService;

@Controller
public class UserController {
	  @Autowired
	  IUserService userService;
	  
	  @ResponseBody
	  @RequestMapping("/")
	  public String home() {
		  return null;
	    }
}
