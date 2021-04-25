package cn.isjinhao.sc.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author ISJINHAO
 * @Date 2021/4/25 21:55
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosFeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosFeignProviderApplication.class, args);
    }

}
