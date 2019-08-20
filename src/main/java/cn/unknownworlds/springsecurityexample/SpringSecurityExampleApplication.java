package cn.unknownworlds.springsecurityexample;

import cn.unknownworlds.springsecurityexample.servlet.VerifyServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = {"cn.unknownworlds.springsecurityexample.mapper"})
public class SpringSecurityExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityExampleApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new VerifyServlet());
        registrationBean.addUrlMappings("/getVerifyCode");
        return registrationBean;
    }
}
