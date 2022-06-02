package iut.uca.twibook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iut.uca.twibook.entities.PostEntity;
import iut.uca.twibook.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public PostEntity findById;

}
