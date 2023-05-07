package ru.kata.spring.boot_security.demo.util;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.UserService;

@Component
public class UserValidator {

    //проверка на существование в базе пользователя с таким логином и(или) email
    public static boolean validate(User user, Model model, UserService userService) {
        if (userService.findUserByUsername(user.getUsername()) != null ) {
            model.addAttribute("userExistsError1", true);
            return true;
        }
        if (userService.findUserByEmail(user.getEmail()) != null ) {
            model.addAttribute("userExistsError2", true);
            return true;
        }
        return false;
    }
}
