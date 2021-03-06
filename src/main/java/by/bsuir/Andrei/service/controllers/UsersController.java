package by.bsuir.Andrei.service.controllers;

import by.bsuir.Andrei.service.forms.UserForm;
import by.bsuir.Andrei.service.models.User;
import by.bsuir.Andrei.service.services.UsersService;
import by.bsuir.Andrei.service.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.bsuir.Andrei.service.transfer.UserDto.from;

@RestController
public class UsersController {


    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return from( usersService.findAll());
    }

    @GetMapping("/users/{user-id}")
    public User getUser(@PathVariable("user-id") Long userId) {
        return usersService.findOne(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody UserForm userForm){
        usersService.signUp(userForm);
        return ResponseEntity.ok().build();
    }
}
