package cn.isjinhao.sc.provider.server;

import cn.isjinhao.sc.provider.api.NacosDubboService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Author ISJINHAO
 * @Date 2021/4/18 19:24
 */
@DubboService
public class NacosDubboServiceImpl implements NacosDubboService {

    @Override
    public String nacosDubboService() {
        return "nacosDubboService is called!";
    }

}
