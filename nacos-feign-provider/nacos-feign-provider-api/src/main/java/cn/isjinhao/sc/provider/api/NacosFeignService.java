package cn.isjinhao.sc.provider.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ISJINHAO
 * @Date 2021/4/18 19:22
 */
@FeignClient(name="nacos-feign-provider")
public interface NacosFeignService {

    @RequestMapping(value = "/nacosFeignService")
    String nacosFeignService();

}
