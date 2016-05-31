package com.imtiyaz.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig2 {

    @Bean
    public Address address() {
        return new Address();
    }
}
