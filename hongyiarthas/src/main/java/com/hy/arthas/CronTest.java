package com.hy.arthas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableScheduling
public class CronTest implements InitializingBean {
    @Override
    public void afterPropertiesSet() {}

    @Scheduled(cron="*/5 * * * * ?")
    public void cronTest() {
        log.info("cron: "+System.currentTimeMillis());
    }
}
