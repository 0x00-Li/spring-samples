package com.example;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.NacosNamingMaintainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 */
@SpringBootApplication
public class ManualWeightApplication {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(ManualWeightApplication.class, args);
    }

    @RestController
    class WeightController {
        NamingService naming = null;
        NacosNamingMaintainService maintainService=null;
        public WeightController() throws NacosException {
            Properties props = new Properties();
            props.put("serverAddr","registry.gamma.t.ziroom.com");
            props.put("namespace","public");
            naming = NamingFactory.createNamingService(props);
            maintainService=new NacosNamingMaintainService(props);
        }

        @RequestMapping("instances")
        public List<Instance> getInstance() throws NacosException {
            return naming.getAllInstances("server-samples");
        }

        @RequestMapping("weight")
        public String setWeight() throws NacosException {
            List<Instance> allInstances = naming.getAllInstances("server-samples");
            Instance instance = allInstances.stream().filter(i -> i.getPort() == 18082).findAny().get();
            instance.setWeight(20d);

            maintainService.updateInstance(instance.getServiceName(), instance);

            return "ok";
        }
    }
}
