package com.itstep.diploma.configuration;

import com.itstep.diploma.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    public SpringSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //Требуется для предотвращения применения безопасности к ресурсам
    String[] resources = new String[]{
            "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/", "/index", "/about").permitAll()
                .antMatchers("/admin*").access("hasRole('ADMIN')")
                .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")

                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()

                //Настройка для входа в систему
                .formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/menu")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .usernameParameter("password")

                //Перенарпавление на главную страницу после успешного входа
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }

    BCryptPasswordEncoder bCryptPasswordEncoder;

    //Шифратор паролей
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //Число 4 показывает, насколько надежно вы хотите шифрование. Он может находиться в диапазоне от 4 до 31.
        //Если не указать число, программа будет использовать его каждый раз случайным образом,
        //поэтому зашифрованные пароли не будут работать.
        return bCryptPasswordEncoder;
    }

    //Регистрация сервиса для пользователей и шифратора паролей
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //Настройка службы для поиска пользователя в базе данных и установка пароляEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
