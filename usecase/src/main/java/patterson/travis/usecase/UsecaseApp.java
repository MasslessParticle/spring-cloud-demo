package patterson.travis.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class UsecaseApp {

    @Autowired
    Employees employees;

    @Autowired
    JobService jobService;

    @RequestMapping("/")
    public EmployeesAndJobs employeesAndJobs() {
        EmployeesAndJobs employeesAndJobs = new EmployeesAndJobs();
        employeesAndJobs.setEmployees(getEmployees());
        employeesAndJobs.setJobs(getJobs());

        return employeesAndJobs;
    }

    private List<String> getEmployees() {
        return employees.employees();
    }

    private List<String> getJobs() {
        return jobService.jobs();
    }

    public static void main(String[] args) {
        SpringApplication.run(UsecaseApp.class, args);
    }
}
