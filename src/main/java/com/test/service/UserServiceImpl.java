package com.test.service;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.test.dao.UserDao;
import com.test.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
 
	private UserDao userDao;
    @Autowired
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
 
    @Transactional
    public List<?> getAllUsers() {
        return userDao.getAllUsers();
    }
 
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }
 
    @Transactional
    public User addUser(User user) {
    	return userDao.addUser(user);
    }
    @Transactional
    public User updateUser(Integer id, User user) {
    	return userDao.updateUser(id, user);
    }
 
    @Transactional
    public User deleteUser(Integer id) {
    	return userDao.deleteUser(id);
    }
}