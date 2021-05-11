package org.example;

import org.example.config.ConfigInfo;

public class SamplesServiceImpl implements SamplesService {
    private String name;
    private String ip;

    @Override
    public ConfigInfo configInfo() {
        ConfigInfo configInfo = new ConfigInfo();
        configInfo.setName(name);
        configInfo.setIp(ip);
        return configInfo;
    }
    public SamplesServiceImpl(String name ,String ip){
        this.name=name;
        this.ip=ip;
    }
}
