package patterson.travis.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeApp {

    private static final String[] EMPLOYEES = {
            "Tony",
            "Mike",
            "Shaun",
            "Rory",
            "Sage",
            "Joshil",
            "Josh",
            "Justin",
            "Rebecca",
            "Chris",
            "Travis",
            "Paul"
    };

    @RequestMapping("/")
    public List<String> employees() {
        return asList(EMPLOYEES);
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApp.class, args);
    }
}
