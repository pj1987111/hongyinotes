package com.zhy.dockertest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  \* Created with IntelliJ IDEA.
 *  \* User: hongyi.zhou
 *  \* Date: 2021-04-01
 *  \* Time: 10:08
 *  \* Description: 
 *  \
 */
@SpringBootApplication
@Slf4j
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
