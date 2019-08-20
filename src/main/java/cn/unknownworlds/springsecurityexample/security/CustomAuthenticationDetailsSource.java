package cn.unknownworlds.springsecurityexample.security;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CustomAuthenticationDetailsSource
 * @Description TODO
 * @Author Administrator
 * @Date 2019/8/20 0020 下午 17:44
 * @Version 1.0
 */
@Component
public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new CustomWebAuthenticationDetails(context);
    }
}
