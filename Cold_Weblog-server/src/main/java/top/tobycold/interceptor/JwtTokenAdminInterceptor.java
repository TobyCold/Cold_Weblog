package top.tobycold.interceptor;

import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.tobycold.admin.BaseContext;
import top.tobycold.admin.JwtConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenAdminInterceptor implements HandlerInterceptor {
    //TODO token 不需要解密就能拿值，头和体是不加密的，而是base64编码，而最后签名是加密的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("请求端验证ip:{}",request.getLocalAddr());
        String token = request.getHeader(JwtConfig.TOKEN);
        //解密token
        JWT jwt = JWTUtil.parseToken(token);

            //校验时间
        JWTValidator.of(jwt).validateDate(new Date(System.currentTimeMillis()));

        JSONObject payloads = jwt.getPayloads();
        //这里将id存储在线程空间中ThreadLocal
        BaseContext.setContext((String)payloads.get(JwtConfig.EID));
        //放行
        return true;
    }

}
