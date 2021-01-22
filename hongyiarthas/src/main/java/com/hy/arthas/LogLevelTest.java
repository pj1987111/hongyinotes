package com.hy.arthas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableScheduling
public class LogLevelTest implements InitializingBean {
    @Override
    public void afterPropertiesSet() {}

    @Scheduled(cron="*/15 * * * * ?")
    public void logLevel() {
        log.debug("log debug message timestamp is : "+System.currentTimeMillis());
        log.info("log info message timestamp is : "+System.currentTimeMillis());
    }
}
