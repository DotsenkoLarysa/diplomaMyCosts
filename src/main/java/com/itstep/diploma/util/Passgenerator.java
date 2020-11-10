package com.itstep.diploma.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Passgenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //Строка, которую мы отправляем методу кодирования, - это пароль, который мы хотим зашифровать.
        System.out.println(bCryptPasswordEncoder.encode("123123"));
    }
}
