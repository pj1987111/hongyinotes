package com.hy.arthas.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  \* Created with IntelliJ IDEA.
 *  \* User: hongyi.zhou
 *  \* Date: 2021-01-18
 *  \* Time: 13:57
 *  \* Description: 耗时，监控测试
 *  \
 */
@Service
@Slf4j
public class ArthasService {
    private static List<String> cache = new ArrayList<>();
    private List<String> fieldCache = new ArrayList<>();

    public void get(Integer uid) throws Exception {
        check(uid);
        small(uid);
        medium(uid);
        high(uid);
    }

    public void small(Integer uid) throws Exception {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count += i;
        }
        log.info("small end {}", count);
    }

    public void medium(Integer uid) throws Exception {
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            count += i;
        }
        log.info("medium  end {}", count);
    }

    public void high(Integer uid) throws Exception {
        long count = 0;
        for (int i = 0; i < 10000000; i++) {
            count += i;
        }
        log.info("high end {}", count);
    }

    public boolean check(Integer uid) throws Exception {
        if (uid == null || uid < 0) {
            log.error("uid不正确，uid:{}", uid);
            throw new Exception("uid不正确");
        }
        return true;
    }

    public Map<String, String> putVal(String uid) {
        cache.add("uid===>" + uid);
        fieldCache.add("local:"+uid);
        return cache.stream().collect(Collectors.toMap(String::toString, String::toUpperCase, (key1, key2) -> key2));
    }
}
