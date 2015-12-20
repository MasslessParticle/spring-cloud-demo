package patterson.travis.usecase;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.*;

@Service
public class JobService {

    @Autowired
    private RestTemplate rest;

    @HystrixCommand(fallbackMethod = "defaultJob")
    public List<String> jobs() {
        return (List<String>)rest.getForObject("http://jobs/", Object.class);
    }

    public List<String> defaultJob() {
        return asList("Default Job");
    }
}
