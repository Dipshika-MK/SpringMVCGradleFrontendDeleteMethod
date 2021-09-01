package com.test.dao;
 
import java.util.List;
import com.test.model.User;

public interface UserDao {
 
    public List<?> getAllUsers();
    public User getUser(int id);
    public User addUser(User user);
    public User updateUser(Integer id,User user);
    public User deleteUser(Integer id);
    
}