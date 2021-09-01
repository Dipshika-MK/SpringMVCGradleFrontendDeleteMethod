package com.test.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.test.model.User;
 
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	

	@Autowired
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    private final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

    public List<?> getAllUsers() {
        
        List<?> userList =  getCurrentSession().createQuery("from User").list();
        return userList;
    }
 
    public User getUser(int id) {
       
        User user = (User)  getCurrentSession().get(User.class, new Integer(id));
        return user;
    }
 
    public User addUser(User user) {
        
    	 getCurrentSession().persist(user);
        return user;
    }
    public User updateUser(Integer id, User user) { //http://localhost:8086/Test/user/updateUser/206
       
        User user1 =  getCurrentSession().get(User.class, id);
        user1.setEmail(user.getEmail());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getEmail());
        user1.setPassword(user.getPassword());
        getCurrentSession().update(String.valueOf(id), user1);
        return user1;
    }
 
    public User deleteUser(Integer id) {

        User p = (User)  getCurrentSession().load(User.class, new Integer(id));
        if (null != p) {
        	 getCurrentSession().delete(p);
        }
		return null;
    }


	} 
