package com.goonok.dao;

import java.util.List;

import com.goonok.entity.User;

public interface UserDao {

	public int registerUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public User getUserById(int id);
	
	public List<User> getAllUserInformation();
	
	public User loginUser(String email, String password);
}
