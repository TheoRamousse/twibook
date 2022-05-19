package iut.uca.twibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iut.uca.twibook.repository.IPostRepository;
import iut.uca.twibook.service.interfaces.IPostService;

@Service
public class PostService implements IPostService {

	
	@Autowired
	IPostRepository postRepository;

}
