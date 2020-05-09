package it.polito.ezgas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.UserService;

/**
 * Created by softeng on 27/4/2020.
 */
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository repositoryUser;
	

	@Override
	public UserDto getUserById(Integer userId) throws InvalidUserException {
		if(userId==null || userId<0) {
			throw new InvalidUserException("Wrong userID");
		}
		else {
		User user=repositoryUser.findOne(userId);
		if (user!=null) {
			return UserConverter.toUserDto(user);
		}
		else {
		// TODO check
		return null;}
		}
	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		UserDto current=null;
		
		if(userDto.getUserId() == null) {
			User users=UserConverter.toUser(userDto);
			repositoryUser.save(users);
			current=UserConverter.toUserDto(users);
		}
		else {
			User users=repositoryUser.getOne(userDto.getUserId());
			users.setUserName(userDto.getUserName());
			users.setPassword(userDto.getPassword());
			users.setEmail(userDto.getEmail());
			repositoryUser.save(users);
			current = UserConverter.toUserDto(users);
		}
		// TODO check
		return current;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> users= new ArrayList<UserDto>();
		
		for (User current : repositoryUser.findAll()) {
			users.add(UserConverter.toUserDto(current));
		}
		// TODO Check
		return users;
	}

	@Override
	public Boolean deleteUser(Integer userId) throws InvalidUserException {
		if(userId==null || userId<0) {
			throw new InvalidUserException("Wrong userID");
		}
		else {
		repositoryUser.delete(userId);
		// TODO check
		return true;}
	}

	@Override
	public LoginDto login(IdPw credentials) throws InvalidLoginDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer increaseUserReputation(Integer userId) throws InvalidUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer decreaseUserReputation(Integer userId) throws InvalidUserException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
