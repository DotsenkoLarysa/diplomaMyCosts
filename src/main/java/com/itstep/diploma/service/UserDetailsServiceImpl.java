package com.itstep.diploma.service;

import com.itstep.diploma.model.Role;
import com.itstep.diploma.model.User;
import com.itstep.diploma.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Находим пользователя в репозитории и, если он не существует, запускаем исключение
        User appUser =
                null;
        try {
            appUser = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user exists"));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //Сопоставляем наш список полномочий со списком безопасности
        List<GrantedAuthority> grantList = new ArrayList<>();
        for (Role role : Objects.requireNonNull(appUser).getRoleSet()) {
            // USER, ADMIN,..
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantList.add(grantedAuthority);
        }

        //Создаем объект UserDetails, который будет в сеансе, и возвращаем его.
        return (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
    }
}
