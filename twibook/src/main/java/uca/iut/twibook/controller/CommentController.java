package uca.iut.twibook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uca.iut.twibook.service.interfaces.ICommentService;

@Repository
public class CommentController {

	
	@Autowired
	ICommentService commentService;
	
}
