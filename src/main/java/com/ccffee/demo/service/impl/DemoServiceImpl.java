package com.ccffee.demo.service.impl;

import com.ccffee.demo.mbg.mapper.DemoMapper;
import com.ccffee.demo.mbg.model.DemoExample;
import com.ccffee.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public HashMap demo(HashMap param) {
        HashMap result = new HashMap<String, List>();

        result.put("data", demoMapper.selectByExample(new DemoExample()));

        return result;
    }
}
