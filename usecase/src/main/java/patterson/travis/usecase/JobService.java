package patterson.travis.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private RestTemplate rest;

    public List<String> jobs() {
        return (List<String>)rest.getForObject("http://jobs/", Object.class);
    }
}
