package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = userRepository.findById(id).orElse(null);

    if (user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    try {
      User newUser = userRepository.save(user);
      return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    User existingUser = userRepository.findById(id).orElse(null);

    if (existingUser == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    existingUser.setName(user.getName());
    existingUser.setEmail(user.getEmail());

    User updatedUser = userRepository.save(existingUser);

    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
    User existingUser = userRepository.findById(id).orElse(null);

    if (existingUser == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    userRepository.delete(existingUser);

    return new ResponseEntity<>(id, HttpStatus.OK);
  }
}
