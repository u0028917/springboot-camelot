package com.camelot.xiaobing.config;


import com.camelot.xiaobing.core.XiaoBingExceptionAop;
import com.camelot.xiaobing.core.XiaoBingSendMsg;
import com.camelot.xiaobing.props.XiaoBingProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(XiaoBingProperties.class)
@ConditionalOnProperty(value = XiaoBingProperties.PREFIX + ".enabled", havingValue = "true")
public class XiaoBingConfig {

    private final XiaoBingProperties xiaoBingProperties;

    @Bean
    public XiaoBingExceptionAop xiaoBingExceptionAop(ApplicationContext applicationContext) {
        return new XiaoBingExceptionAop(applicationContext);
    }

    @Bean
    public XiaoBingSendMsg xiaoBingSendMsg() {
        return new XiaoBingSendMsg(xiaoBingProperties);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//        };
//    }

}
