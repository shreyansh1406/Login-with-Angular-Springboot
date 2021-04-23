package com.RestServices;


import java.net.URI;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.RestServices.Repository.UserRepository;
import com.RestServices.User.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController  
public class UserController  
{  
	@Autowired
	private UserRepository userRepo;
  



@DeleteMapping("/{id}")  
public String deleteUser(@PathVariable long id)  
{  
 userRepo.deleteById( id);   
 return "Successfully deleted from the the database";
} 



@GetMapping("/user")
public List<User> listUsers( User li) {
	List<User> listUsers = userRepo.findAll();
	return listUsers;	}


@PostMapping("/add")
public String examRegister(@RequestBody User li) {
	
	userRepo.save(li);
	
	return "Successfully Added in the database";
}   
}  


