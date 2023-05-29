package ma.enset.digitalbanking.web;

import lombok.AllArgsConstructor;
import ma.enset.digitalbanking.entities.User;
import ma.enset.digitalbanking.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    //Call it whenever building the application
    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUsers();
    }

    @PostMapping({"/registernewuser"})
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

    @GetMapping({"/foradmin"})
    @PreAuthorize("hasRole('admin')")
    public String forAdmin(){
        return "Accessible just for admin";
    }

    @GetMapping({"/foruser"})
    @PreAuthorize("hasRole('user')")
    public String forUser(){
        return "Accessible just for user";
    }
}

