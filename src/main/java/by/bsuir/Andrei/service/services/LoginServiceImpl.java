package by.bsuir.Andrei.service.services;

import by.bsuir.Andrei.service.forms.LoginForm;
import by.bsuir.Andrei.service.models.Token;
import by.bsuir.Andrei.service.models.User;
import by.bsuir.Andrei.service.repositories.TokensRepository;
import by.bsuir.Andrei.service.repositories.UsersRepository;
import by.bsuir.Andrei.service.transfer.TokenDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static by.bsuir.Andrei.service.transfer.TokenDto.from;


@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userCandidate = usersRepository.findOneByLogin(loginForm.getLogin());
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            if (passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();
                tokensRepository.save(token);
                return from(token);
            }
        }
        throw new IllegalArgumentException("User not found");
    }
}
