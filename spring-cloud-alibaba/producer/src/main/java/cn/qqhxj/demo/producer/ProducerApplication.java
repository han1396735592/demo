package cn.qqhxj.demo.producer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@Api(tags = "App")
@SpringBootApplication
public class ProducerApplication {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String name;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }


    @ApiOperation("info")
    @SentinelResource("info")
    @GetMapping("/info")
    public String test() {
        return name + port;
    }

}
