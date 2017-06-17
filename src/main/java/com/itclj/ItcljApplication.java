package com.itclj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Ehcache3 demo
 * Created by clj on 2017/6/17.
 */
@EnableCaching
@SpringBootApplication
public class ItcljApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItcljApplication.class, args);
    }
}
