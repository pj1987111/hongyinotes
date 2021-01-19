package com.hy.arthas.controller;

import com.hy.arthas.service.ArthasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *  \* Created with IntelliJ IDEA.
 *  \* User: hongyi.zhou
 *  \* Date: 2021-01-18
 *  \* Time: 14:15
 *  \* Description: 
 *  \
 */
@RestController
@Slf4j
public class ArthasController {
    @Autowired
    private ArthasService arthasService;

    @RequestMapping(value = "/get")
    public Map<String, Object> getInfo(Integer uid) throws Exception {
        log.info("get "+uid);
        arthasService.get(uid);
        Map<String, Object> hashMap = new HashMap<>(1);
        hashMap.put("uid", uid);
        return hashMap;
    }

    @RequestMapping(value = "/put")
    public void putTest(String uid) {
        log.info("put "+uid);
        arthasService.putVal(uid);
    }
}
