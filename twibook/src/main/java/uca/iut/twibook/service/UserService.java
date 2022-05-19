package uca.iut.twibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uca.iut.twibook.repository.IUserRepository;
import uca.iut.twibook.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;

}
