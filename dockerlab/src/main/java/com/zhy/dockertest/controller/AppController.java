package com.zhy.dockertest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  \* Created with IntelliJ IDEA.
 *  \* User: hongyi.zhou
 *  \* Date: 2021-04-01
 *  \* Time: 10:15
 *  \* Description: 
 *  \
 */
@RestController
@Slf4j
public class AppController {

  @RequestMapping(value = "/test")
  public String getInfo(Integer uid) throws Exception {
    return "test ok " + uid;
  }
}
