package iut.uca.twibook.services;

import iut.uca.twibook.UserMapper;
import iut.uca.twibook.dtos.UserDTO;
import iut.uca.twibook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserService{

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper = UserMapper.INSTANCE;

    public List<UserDTO> findUsers(){
        return userMapper.listToDTO(userRepository.findAll());
    }
}
