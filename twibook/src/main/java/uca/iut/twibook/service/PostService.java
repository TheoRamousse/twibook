package uca.iut.twibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uca.iut.twibook.repository.IPostRepository;
import uca.iut.twibook.service.interfaces.IPostService;

@Service
public class PostService implements IPostService {

	
	@Autowired
	IPostRepository postRepository;

}
