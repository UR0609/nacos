package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {

        @GetMapping("/hello")
        public String hello() {
            return "helloWorld";
        }
    }
//    json
//    [
//        {
//            "resource": "/hello",
//                "limitApp": "default",
//                "grade": 1,
//                "count": 5,
//                "strategy": 0,
//                "controlBehavior": 0,
//                "clusterMode": false
//        }
//    ]

//    resource：资源名，即限流规则的作用对象
//    limitApp：流控针对的调用来源，若为 default 则不区分调用来源
//    grade：限流阈值类型（QPS 或并发线程数）；0代表根据并发数量来限流，1代表根据QPS来进行流量控制
//    count：限流阈值
//    strategy：调用关系限流策略
//    controlBehavior：流量控制效果（直接拒绝、Warm Up、匀速排队）
//    clusterMode：是否为集群模式
}
