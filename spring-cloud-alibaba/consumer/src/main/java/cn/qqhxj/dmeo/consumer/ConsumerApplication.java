package cn.qqhxj.dmeo.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RefreshScope
@Api("app")
@SpringBootApplication
public class ConsumerApplication {

    @Autowired
    private User user;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String name;

    @Autowired
    private RestTemplate restTemplate;



    @ApiOperation("call")
    @GetMapping("call")
    public String call() {
        return test() + " call "+restTemplate.getForObject("http://producer/info",String.class);
    }


    @ApiOperation("info")
    @SentinelResource(value = "com-info", blockHandler = "block")
    @GetMapping("/info")
    public String test() {
        return name + port;
    }


    public String block() {
        return "接口限流了";
    }

    @GetMapping("/user")
    public User user() {
        return user;
    }

}
