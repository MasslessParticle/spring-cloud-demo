package patterson.travis.job;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class JobApp {

    @Value("${server.port}")
    int port;

    private static final String[] JOBS = {
            "Developer",
            "QA",
            "Assistant",
            "Team Lead"
    };

    @RequestMapping("/")
    public List<String> jobs() {
        List<String> jobs = new ArrayList<>();
        jobs.add(Integer.toString(port));
        jobs.addAll(asList(JOBS));

        return jobs;
    }

    public static void main(String[] args) {
        SpringApplication.run(JobApp.class, args);
    }
}
