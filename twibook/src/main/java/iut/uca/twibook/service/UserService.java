package iut.uca.twibook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iut.uca.twibook.repository.IUserRepository;
import iut.uca.twibook.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;

}
