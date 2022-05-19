package uca.iut.twibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uca.iut.twibook.repository.ICommentRepository;
import uca.iut.twibook.service.interfaces.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Autowired
	ICommentRepository commentRepository;

}
