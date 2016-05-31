package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig2 {

    @Bean
    public Person address() {
        return new Person();
    }
}


