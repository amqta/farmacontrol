package com.farmalink.farmacontrol;

import org.springframework.boot.SpringApplication;

public class TestFarmaControlApplication {

    public static void main(String[] args) {
        SpringApplication.from(FarmaControlApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
