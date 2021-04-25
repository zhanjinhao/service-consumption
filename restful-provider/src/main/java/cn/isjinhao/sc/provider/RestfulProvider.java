package cn.isjinhao.sc.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ISJINHAO
 * @Date 2021/4/18 18:00
 */
@RestController
public class RestfulProvider {

    @GetMapping(value = "restfulProvider")
    public String service() {
        return "restfulProvider is called!";
    }

}
