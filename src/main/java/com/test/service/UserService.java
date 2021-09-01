package com.test.service;
 
import java.util.List;
import com.test.model.User;

public interface UserService {
	
    public List<?> getAllUsers();
    public User getUser(int id);
    public User addUser(User user);
    public User updateUser(Integer id, User user);
    public User deleteUser(Integer id);
    
}