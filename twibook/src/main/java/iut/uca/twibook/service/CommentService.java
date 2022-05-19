package iut.uca.twibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iut.uca.twibook.repository.ICommentRepository;
import iut.uca.twibook.service.interfaces.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Autowired
	ICommentRepository commentRepository;

}
