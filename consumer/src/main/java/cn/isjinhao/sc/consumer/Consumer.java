package cn.isjinhao.sc.consumer;

import cn.isjinhao.sc.provider.api.NacosDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @Author ISJINHAO
 * @Date 2021/4/18 18:04
 */
@RestController
public class Consumer {

    @Value("${provider.address}")
    private String provider;

    @GetMapping(value = "/service1")
    public String service1() {
        // 远程调用
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://" + provider + "/restfulProvider", String.class);
        return "consumer is called! | " + result + " | restTemplate";
    }

    private String serviceId = "nacos-restful-provider-192.168.31.102:56011";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/service2")
    public String service2() {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
        URI uri = serviceInstance.getUri();
        String result = restTemplate.getForObject(uri + "/nacosRestfulProvider", String.class);
        return "consumer is called! | " + result + " | ribbon";
    }

    @DubboReference
    private NacosDubboService nacosDubboService;

    @GetMapping(value = "/service3")
    public String service3() {
        String result = nacosDubboService.nacosDubboService();
        return "consumer is called! | " + result + " | nacos dubbo";
    }

}
