package it.polito.ezgas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.converter.LoginConverter;
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

	public UserServiceimpl(UserRepository userRepository) {
		this.repositoryUser = userRepository;
	}

	@Override
	public UserDto getUserById(Integer userId) throws InvalidUserException {
		if (userId == null || userId.intValue() < 0) {
			throw new InvalidUserException("Wrong userID");
		} else {
			User user = repositoryUser.findOne(userId);
			if (user != null) {
				return UserConverter.toUserDto(user);
			} else {
				// TODO check
				return null;
			}
		}
	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		UserDto current = null;

		if (userDto.getUserId() == null) {
			User user = UserConverter.toUser(userDto);
			user = repositoryUser.save(user);
			current = UserConverter.toUserDto(user);
		} else {
			User user = repositoryUser.getOne(userDto.getUserId());
			user.setUserName(userDto.getUserName());
			user.setPassword(userDto.getPassword());
			user.setEmail(userDto.getEmail());
			user = repositoryUser.save(user);
			current = UserConverter.toUserDto(user);
		}
		// TODO check
		return current;

	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> users = new ArrayList<UserDto>();

		for (User current : repositoryUser.findAll()) {
			users.add(UserConverter.toUserDto(current));
		}
		// TODO Check
		return users;
	}

	@Override
	public Boolean deleteUser(Integer userId) throws InvalidUserException {
		User user = repositoryUser.findOne(userId);
		if (userId == null || userId.intValue() < 0) {
			throw new InvalidUserException("Wrong userID");
		} else {
			if (user == null) {
				return null;
			}
			repositoryUser.delete(userId);
			// TODO check
			return true;
		}
	}

	@Override
	public LoginDto login(IdPw credentials) throws InvalidLoginDataException {
		LoginDto login = null;
		User user = null;

		user = repositoryUser.findByEmail(credentials.getUser());
		if (user == null)
			throw new InvalidLoginDataException("Wrong Email or Password");
		
		if (user.getPassword().equals(credentials.getPw())) {
			login = LoginConverter.toLoginDto(user);
		}
		else {
			throw new InvalidLoginDataException("Wrong Email or Password");
		}

		return login;
	}

	@Override
	public Integer increaseUserReputation(Integer userId) throws InvalidUserException {
		if (userId == null || userId.intValue() < 0) {
			throw new InvalidUserException("Wrong userID");
		}

		User user = repositoryUser.findOne(userId);
		Integer reputation = user.getReputation();
		if (reputation.intValue() < 5) {
			reputation = new Integer(reputation.intValue() + 1);
		}
		user.setReputation(reputation);
		repositoryUser.save(user);

		// TODO check
		return reputation;
	}

	@Override
	public Integer decreaseUserReputation(Integer userId) throws InvalidUserException {
		if (userId == null || userId.intValue() < 0) {
			throw new InvalidUserException("Wrong userID");
		}

		User user = repositoryUser.findOne(userId);
		Integer reputation = user.getReputation();
		if (reputation.intValue() > -5) {
			reputation = new Integer(reputation.intValue() - 1);
		}
		user.setReputation(reputation);
		repositoryUser.save(user);
		// TODO check
		return reputation;
	}

}
