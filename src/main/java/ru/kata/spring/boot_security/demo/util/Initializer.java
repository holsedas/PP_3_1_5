package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Initializer {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Initializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");

        roleService.saveRole(role1);
        roleService.saveRole(role2);

        User user1 = new User("ivan_ivanov@gmail.com", "100",
                "Иван", "Иванов", 55,
                new HashSet<>(Set.of(role1)));
        User user2 = new User("alex_alexandrov@gmail.com", "100",
                "Александр", "Александров", 32,
                new HashSet<>(Set.of(role2)));

        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
