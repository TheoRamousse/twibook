package iut.uca.twibook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iut.uca.twibook.service.interfaces.ICommentService;

@Repository
public class CommentRepository  {

	
	@Autowired
	ICommentService commentService;
	
}
