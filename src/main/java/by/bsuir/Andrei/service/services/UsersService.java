package by.bsuir.Andrei.service.services;

import by.bsuir.Andrei.service.forms.UserForm;
import by.bsuir.Andrei.service.models.User;

import java.util.List;

public interface UsersService {
    void signUp(UserForm userForm);

    List<User> findAll();

    User findOne(Long userId);
}
