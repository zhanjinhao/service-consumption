package cn.isjinhao.sc.provider;

import cn.addenda.businesseasy.propertyrefresh.PropertyRefresh;
import cn.addenda.businesseasy.propertyrefresh.PropertyRefreshHolder;
import cn.addenda.businesseasy.propertyrefresh.PropertyRefreshListener;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author ISJINHAO
 * @Date 2021/4/18 19:04
 */
@RestController
@Transactional(rollbackFor = Exception.class)
public class NacosRestfulProvider implements InitializingBean, PropertyRefreshListener {

    @Value("#{'${propertyrefreshtest}'.split(',')}")
    @PropertyRefresh
    private List<String> addressList;

    // 暴露RESTful接口
    @GetMapping(value = "/nacosRestfulProvider")
    public String service() {
        return "nacosRestfulProvider is called!";
    }

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    @Override
    public void afterPropertiesSet() throws Exception {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println(addressList);
        }, 10, 10, TimeUnit.SECONDS);
    }

    @Override
    public void doPropertyRefresh(PropertyRefreshHolder propertyRefreshHolder) {
        System.out.println(propertyRefreshHolder);
        if (propertyRefreshHolder.getFieldName().equals("addressList")) {
            addressList = (List<String>) propertyRefreshHolder.getNewValue();
        }
    }

}
