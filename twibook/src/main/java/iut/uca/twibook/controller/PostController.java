package iut.uca.twibook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import iut.uca.twibook.service.interfaces.IPostService;

@Controller
public class PostController {

	  @Autowired
	  IPostService postService;
	  
}
