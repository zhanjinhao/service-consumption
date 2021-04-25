package cn.isjinhao.sc.provider.server;

import cn.isjinhao.sc.provider.api.NacosFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ISJINHAO
 * @Date 2021/4/25 21:56
 */
@RestController
public class NacosFeignServiceImpl implements NacosFeignService {


    @GetMapping("/nacosFeignService")
    @Override
    public String nacosFeignService() {
        return "nacosFeignService is called!";
    }
}
