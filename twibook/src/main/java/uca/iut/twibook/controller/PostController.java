package uca.iut.twibook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import uca.iut.twibook.service.interfaces.IPostService;

@Controller
public class PostController {

	  @Autowired
	  IPostService postService;
	  
}
