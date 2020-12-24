package com.ccffee.demo.controller;

import com.ccffee.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public HashMap demo(@RequestBody HashMap param){
        return demoService.demo(param);
    }
}
