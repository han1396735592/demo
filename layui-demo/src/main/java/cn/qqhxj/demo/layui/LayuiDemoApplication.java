package cn.qqhxj.demo.layui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @date 10-24
 * @author hanxinjian
 */
@MapperScan({"cn.qqhxj.demo.layui.dao", "cn.qqhxj.demo.layui.modules.*.dao"})
@SpringBootApplication
public class LayuiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayuiDemoApplication.class, args);
    }
}
