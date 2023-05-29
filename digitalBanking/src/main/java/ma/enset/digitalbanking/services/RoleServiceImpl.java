package ma.enset.digitalbanking.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.digitalbanking.entities.Role;
import ma.enset.digitalbanking.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    @Override
    public Role createNewRole(Role role) {
        log.info("new role created");
        return roleRepository.save(role);
    }
}
