package ie.mam.mfinity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ie.mam.mfinity.model.User;
import ie.mam.mfinity.repository.UserRepository;

@Controller
@RequestMapping(path="/user")
public class UserController{
  @Autowired
  private UserRepository userRepository;

  @GetMapping(path="add")
  @CrossOrigin(origins = "http://marcioalmeidamendes.ml:4200")
  public @ResponseBody String addNewUser(@RequestParam String userName, @RequestParam String password){
  User user=new User( userName, password) ;
    userRepository.save(user);
   return "Saved";
  }

 
    @RequestMapping(value="addUser", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://marcioalmeidamendes.ml:4200")
    public  @ResponseBody String addUser(@RequestBody User user) {
	    userRepository.save(user);
	   return "User Saved";

//        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

   @PostMapping(value="add")
   @CrossOrigin(origins = "http://marcioalmeidamendes.ml:4200")
    public User create(@RequestBody User user){
        return userRepository.save(user);
   }
    
    
    
  @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
  @CrossOrigin(origins = "http://marcioalmeidamendes.ml:4200")
  public @ResponseBody User update(@PathVariable("id") String id, @RequestBody User user) {
        return new User("User name","password");
  }

  @GetMapping(path="/list")
  @CrossOrigin(origins = "http://marcioalmeidamendes.ml:4200")
  public @ResponseBody Iterable<User> getAllUsers(){
    return userRepository.findAll();
 }



}



