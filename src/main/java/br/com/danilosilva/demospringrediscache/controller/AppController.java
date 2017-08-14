package br.com.danilosilva.demospringrediscache.controller;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@CacheConfig(cacheNames = "testes")
@RestController
public class AppController {

    @Cacheable
    @RequestMapping("/info")
    public String info(@RequestParam(value = "name") String name) {
        Instant i = null;
        try {
            Thread.sleep(5000L);
            i = Instant.now();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return  "Hello " + name + ". time="+i ;
    }

}
