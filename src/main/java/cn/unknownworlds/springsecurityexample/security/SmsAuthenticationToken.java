package cn.unknownworlds.springsecurityexample.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @ClassName SmsAuthenticationToken
 * @Description TODO
 * @Author Administrator
 * @Date 2019/8/21 0021 上午 9:20
 * @Version 1.0
 */
public class SmsAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;

    /**
     * @Author Administrator
     * @Description 未鉴权的构造器
     * @Date 2019/8/21 0021 上午 9:25
     * @Param [principal]
     * @Return
     * @Exception
     */
    public SmsAuthenticationToken(Object principal) {
        super(null);
        this.principal = principal;
        setAuthenticated(false);
    }

    /**
     * @Author Administrator
     * @Description 鉴权的构造器
     * @Date 2019/8/21 0021 上午 9:25
     * @Param [principal, authorities]
     * @Return
     * @Exception
     */
    public SmsAuthenticationToken(Object principal,
                                  Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true); // must use super, as we override
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }
}
