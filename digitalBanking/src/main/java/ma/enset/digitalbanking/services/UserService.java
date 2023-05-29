package ma.enset.digitalbanking.services;


import ma.enset.digitalbanking.entities.User;

public interface UserService {
    User registerNewUser(User user);
    void initRolesAndUsers();
}
