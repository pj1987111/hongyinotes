package com.hy.arthas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  \* Created with IntelliJ IDEA.
 *  \* User: hongyi.zhou
 *  \* Date: 2021-01-18
 *  \* Time: 13:54
 *  \* Description: 
 *  \
 */
@SpringBootApplication
@Slf4j
public class ArthasApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArthasApplication.class, args);
        Problems.start();
    }
}
