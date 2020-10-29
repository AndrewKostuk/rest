package by.bsuir.Andrei.service.services;

import by.bsuir.Andrei.service.forms.LoginForm;
import by.bsuir.Andrei.service.transfer.TokenDto;

public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
