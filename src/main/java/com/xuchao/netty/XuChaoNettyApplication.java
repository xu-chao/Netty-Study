package com.xuchao.netty;

import com.xuchao.common.security.annotation.EnableCustomConfig;
import com.xuchao.common.security.annotation.EnableAllFeignClients;
import com.xuchao.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xuchao
 * @title: XuChaoNettyApplication
 * @projectName xuchao
 * @description: TODO
 * @date 2021/10/2715:32
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableAllFeignClients
@SpringBootApplication
public class XuChaoNettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(XuChaoNettyApplication.class, args);
    }

}
