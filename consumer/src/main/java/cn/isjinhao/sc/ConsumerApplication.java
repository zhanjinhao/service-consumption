package cn.isjinhao.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author ISJINHAO
 * @Date 2021/4/18 18:05
 */
@EnableFeignClients
@SpringBootApplication
public class ConsumerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
