package com.itstep.diploma.configuration;

import com.itstep.diploma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public SpringSecurityConfig(UserService userService) {
        this.userService = userService;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    //Требуется для предотвращения применения безопасности к ресурсам
    String[] resources = new String[]{
            "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                //Доступ тільки для не зареєстрованих користувачів
                .antMatchers("/registration").not().fullyAuthenticated()

                //Доступ тільки для користувачів з роллю Адміністратор
//                .antMatchers("/admin*").hasRole("ADMIN")
                .antMatchers("/admin*").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers(resources).permitAll()
                .antMatchers("/", "/index", "/about").permitAll()
                //Решта сторінок потребують аутентифікації
                //.anyRequest().authenticated()
                .and()
                //Налаштування для входу в систему
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/index").permitAll()
                .failureUrl("/login?error=true")
//                .usernameParameter("username")
//                .usernameParameter("password")

                //Перенаправлення на головну сторінку після успішного входу
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/index");
    }


    //Регистрация сервиса для пользователей и шифратора паролей
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //Настройка службы для поиска пользователя в базе данных и установка пароляEncoder
        auth.inMemoryAuthentication().
                withUser("Larisa").password("123123").roles("ADMIN");
    }

//    @Bean
//    public RoleHierarchyImpl roleHierarchy() {
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        String hierarchy = "ADMIN > USER ";
//        roleHierarchy.setHierarchy(hierarchy);
//        return roleHierarchy;
//    }
//
//    @Override
//    public void configure(WebSecurity web) {
//        DefaultWebSecurityExpressionHandler expressionHandler = new
//                DefaultWebSecurityExpressionHandler();
//        expressionHandler.setRoleHierarchy(roleHierarchy());
//        web.expressionHandler(expressionHandler);
//    }

}
