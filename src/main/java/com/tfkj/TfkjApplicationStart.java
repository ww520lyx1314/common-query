package com.tfkj;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.tfkj.*.dao")
@SpringBootApplication
@EnableCaching
public class TfkjApplicationStart extends SpringBootServletInitializer {
        public static void main(String[] args) {
            SpringApplication.run(TfkjApplicationStart.class, args);
            System.out.println("ヾ(◍°∇°◍)ﾉﾞ    tfkj-web启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" );
        }

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            // 注意这里要指向原先用main方法执行的Application启动类
            return builder.sources(TfkjApplicationStart.class);
        }
    }
