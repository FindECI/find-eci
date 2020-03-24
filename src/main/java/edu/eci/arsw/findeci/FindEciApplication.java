package edu.eci.arsw.findeci;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FindEciApplication {

    public static void main(String[] args) {
        //SpringApplication app = new SpringApplication(FindEciApplication.class);
        //app.setBannerMode(Banner.Mode.OFF);
        //app.run(args);
    	SpringApplication.run(FindEciApplication.class, args);
    }

}
