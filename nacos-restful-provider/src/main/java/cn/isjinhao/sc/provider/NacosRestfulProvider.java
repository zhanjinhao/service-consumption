package cn.isjinhao.sc.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ISJINHAO
 * @Date 2021/4/18 19:04
 */
@RestController
public class NacosRestfulProvider {

    // 暴露RESTful接口
    @GetMapping(value = "/nacosRestfulProvider")
    public String service() {
        return "nacosRestfulProvider is called!";
    }

}
