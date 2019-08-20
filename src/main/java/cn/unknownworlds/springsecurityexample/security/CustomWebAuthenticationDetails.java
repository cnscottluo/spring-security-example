package cn.unknownworlds.springsecurityexample.security;

import lombok.Getter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CustomWebAuthenticationDetails
 * @Description TODO
 * @Author Administrator
 * @Date 2019/8/20 0020 下午 17:42
 * @Version 1.0
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    @Getter
    private final String verifyCode;

    /**
     * Records the remote address and will also set the session Id if a session already
     * exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.verifyCode = request.getParameter("verifyCode");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("; VerifyCode: ").append(this.getVerifyCode());
        return sb.toString();
    }
}
