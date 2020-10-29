package by.bsuir.Andrei.service.controllers;

import by.bsuir.Andrei.service.forms.LoginForm;
import by.bsuir.Andrei.service.services.LoginService;
import by.bsuir.Andrei.service.transfer.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    public LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(loginService.login((loginForm)));
    }
}
