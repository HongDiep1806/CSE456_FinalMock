package vn.edu.eiu.cse456.fecse4562131200119review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FeCse4562131200119ReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeCse4562131200119ReviewApplication.class, args);
    }

}
