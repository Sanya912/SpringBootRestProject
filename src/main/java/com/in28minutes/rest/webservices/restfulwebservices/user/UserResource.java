package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.in28minutes.rest.webservices.restfulwebservices.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

   @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    /*        @GetMapping("/users/{id}")
           public Resource<User> retrieveUser(@PathVariable int id)  {
               User user = service.findOne(id);
               if(user==null){
                   throw  new UserNotFoundException("id-"+id);
               }

               Resource<User> resource = new Resource<User>(user);
               ControllerLinkBuilder linkto = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.
                       methodOn(this.getClass()).retrieveAllUsers());
               resource.add(linkto.withRel("all-users"));
               return resource;
           }*/
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id)  {
        User user = service.findOne(id);
        if(user==null){
            throw  new UserNotFoundException("id-"+id);
        }
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser =  service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)  {
        User user = service.delete(id);
        if(user==null){
            throw  new UserNotFoundException("id-"+id);
        }
    }


}
