package ma.enset.digitalbanking.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.digitalbanking.entities.Role;
import ma.enset.digitalbanking.entities.User;
import ma.enset.digitalbanking.repositories.RoleRepository;
import ma.enset.digitalbanking.repositories.UserRespository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private RoleRepository roleRepository;
    private UserRespository userRespository;
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerNewUser(User user) {
        Role role = roleRepository.findById("user").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        log.info("new user registered "+user.getUserLogin());
        return userRespository.save(user);
    }

    @Override
    public void initRolesAndUsers() {
        Role adminRole = new Role();
        Role userRole = new Role();
        adminRole.setRoleName("admin");
        adminRole.setRoleDescription("Admin has all rights to see details of accounts and customers, and to all CRUD operations");
        userRole.setRoleName("user");
        userRole.setRoleDescription("Defautl role for newly");
        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserLogin("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userRespository.save(adminUser);

/*        User user = new User();
        user.setUserFirstName("manar-elhouda");
        user.setUserLasttName("badre-eddine");
        user.setUserLogin("manar123");
        user.setUserPassword(getEncodedPassword("manar@badre"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);
        userRespository.save(user);*/
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
