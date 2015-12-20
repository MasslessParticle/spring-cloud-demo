package patterson.travis.employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.util.Arrays.*;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeApp {

    @Value("${server.port}")
    int port;

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
        List<String> employees = new ArrayList<>();
        employees.add(Integer.toString(port));
        employees.addAll(asList(EMPLOYEES));

        return employees;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApp.class, args);
    }
}
