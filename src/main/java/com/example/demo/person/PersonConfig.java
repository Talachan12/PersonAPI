package com.example.demo.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PersonConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args -> {
            Person misiek;
            misiek = new Person(1L,
                     "talachan", "Misiek",
                    23, LocalDate.of(2000,11,19),
                    "misiek@gmail.com");
            repository.saveAll(List.of(misiek));
        };
    }
}
