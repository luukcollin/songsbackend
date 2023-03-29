package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//        CREATE DATABASE music;
//        USE music;
//        CREATE TABLE songs3 (
//        id INT AUTO_INCREMENT,
//        artist VARCHAR(255) NOT NULL,
//        title VARCHAR(255) NOT NULL,
//        starred BIT DEFAULT 0,
//        created INT(14) NOT NULL,
//        genre VARCHAR(255) NOT NULL,
//        PRIMARY KEY (id)
//        );

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

