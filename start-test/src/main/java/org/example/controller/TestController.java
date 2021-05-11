package org.example.controller;

import org.example.SamplesService;
import org.example.config.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    SamplesService samplesService;

    @RequestMapping("config")
    public ConfigInfo config() {
        return samplesService.configInfo();
    }
}
