package com.test.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test.dao.UserDao;
import com.test.model.User;
import com.test.service.UserService;
 
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
	@Qualifier("userService")
	UserService userService;
    
	public void setUserService(UserService userService)
	{
		this.userService=userService;
	}
 
/*	 @GetMapping(value = "/getAllUser")
    public List<?> getUsers() {
        List listOfUsers = (List) userService.getAllUsers();
        return listOfUsers;
    }*/
	
    @GetMapping("/sample")
 	 public ModelAndView importArticle() {
 		 ModelAndView modelView = new ModelAndView();
 		
 	  	modelView.setViewName("/index");
 	  	return modelView;
    }
 
	@GetMapping("/getAllUsers")
    public List<User> getUsers() {
        List<User> listOfUsers = (List<User>) userService.getAllUsers(); // changed
        return listOfUsers;
    }
	   @GetMapping(value = "/getUser")
    public User getUserById(@RequestParam int id) {
        return userService.getUser(id);
    }
 
	   @PostMapping("/addUser")
	    public void addUser(@RequestBody User user) {
	        userService.addUser(user);
	    }
	    @PutMapping("/updateUser/{id}")
	    public User updateUser(@PathVariable int id, @RequestBody User user) {
	    	return userService.updateUser(id, user);
	    }
/* 
    @DeleteMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);  
 
   	 }
    */
	    
    @DeleteMapping("/deleteUserById/{id}")
	public Detail deleteUserById(@PathVariable("id") Integer id ) {
   		userService.deleteUser(id);
   		Detail detail = new Detail();
   		detail.setMessage("Deleted Successfuly");
		return detail;
	}
	
    @GetMapping("/sampledel")
 	 public ModelAndView importArticles() {
 	    ModelAndView modelView = new ModelAndView("/index");
 	  	return modelView;
 	  	
 	  	
    }
    
   /* @RequestMapping(value = "/userdel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting User with id " + id);
  
       // User user = userService.deleteUser(id);
        User user1 = userService.deleteUser(id);
        if (user1 == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        userService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }*/
  
      
 
    } 

    

 
