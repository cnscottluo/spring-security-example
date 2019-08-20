package cn.unknownworlds.springsecurityexample.config;

import cn.unknownworlds.springsecurityexample.filter.VerifyFilter;
import cn.unknownworlds.springsecurityexample.security.CustomAuthenticationProvider;
import cn.unknownworlds.springsecurityexample.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2019/8/20 0020 下午 16:19
 * @Version 1.0
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
        //    @Override
        //    public String encode(CharSequence rawPassword) {
        //        return rawPassword.toString();
        //    }
        //
        //    @Override
        //    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        //        return encodedPassword.equals(rawPassword.toString());
        //    }
        //});

        auth.authenticationProvider(customAuthenticationProvider);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/getVerifyCode").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login/error")
                .permitAll()
                .authenticationDetailsSource(authenticationDetailsSource)
                .and()
                //.addFilterBefore(new VerifyFilter(), UsernamePasswordAuthenticationFilter.class)
                .logout().permitAll()
                .and()
                .rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60)
                .userDetailsService(userDetailsService);

        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**");
    }
}
