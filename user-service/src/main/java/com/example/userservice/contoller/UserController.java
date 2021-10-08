package com.example.userservice.contoller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        
    	return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
   
    }
    

    @GetMapping("/{id}")
    public ResponseEntity< ResponseTemplateVO> findUserwithDepartmentById(@PathVariable("id") Long userId) {

    	return new ResponseEntity< ResponseTemplateVO>(userService.findUserWithDepartmentById(userId), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long departmentId) {
    	
    	userService.deleteUserById(departmentId);
    	return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
    
}


/*
 * @GetMapping("/") public ResponseEntity<List<User>> findAllDepartment() {
 * 
 * return new ResponseEntity<List<User>>(userService.findAllUser(),
 * HttpStatus.OK);
 * 
 * }
 */
	
	
	/*
	 * @PostMapping("/") public User saveUser(@RequestBody User user) { return
	 * userService.saveUser(user); }
	 * 
	 * @GetMapping("/{id}") public ResponseTemplateVO
	 * getUserWithDepartment(@PathVariable("id") Long userId ) { return
	 * userService.getUserWithDepartment(userId); }
	 */


