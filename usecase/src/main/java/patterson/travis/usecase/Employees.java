package patterson.travis.usecase;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("employees")
public interface Employees {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<String> employees();
}
