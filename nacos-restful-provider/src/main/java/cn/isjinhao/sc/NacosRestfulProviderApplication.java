package cn.isjinhao.sc;

import cn.addenda.businesseasy.propertyrefresh.EnablePropertyRefresh;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author ISJINHAO
 * @Date 2021/4/18 19:08
 */
@EnablePropertyRefresh(threadSizes = 2)
@SpringBootApplication
@EnableTransactionManagement
public class NacosRestfulProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosRestfulProviderApplication.class, args);
    }

}
