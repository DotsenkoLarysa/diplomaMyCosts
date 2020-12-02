package com.itstep.diploma.service;

import com.itstep.diploma.model.Role;
import com.itstep.diploma.model.User;
import com.itstep.diploma.repository.RoleRepository;
import com.itstep.diploma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Находим пользователя в репозитории и, если он не существует, запускаем исключение
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }
        return user;
    }

    public User findUserById(Long user_id) {
        Optional<User> userFromDb = userRepository.findById(user_id);
        return userFromDb.orElse(new User());
    }


    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            return false;
        }
        User userNew = new User();
        userNew.setUsername(user.getUsername());
        userNew.setPassword(user.getPassword());
        userNew.setCreate_time(new Date());
        userNew.setRole(new Role(2, "USER"));
        userRepository.save(userNew);
        return true;
    }

    public boolean deleteUser(Long user_id) {
        if (userRepository.findById(user_id).isPresent()) {
            userRepository.deleteById(user_id);
            return true;
        }
        return false;
    }

    public List<User> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM user u WHERE u.user_id > :paramId", User.class)
                .setParameter("paramId", idMin).getResultList();
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        Role userRole = user.getRole();
        return AuthorityUtils.createAuthorityList(String.valueOf(userRole));
    }

}

