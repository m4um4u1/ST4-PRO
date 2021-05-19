package com.example.core;


import dk.sdu.mmmi.semproject.OPC_Common.CommandUA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {


    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);

        CommandUA ca = new CommandUA();
        ca.commandUA();

    }

}


