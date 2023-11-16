package top.tobycold.controller.login;


import com.sun.deploy.net.HttpRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.controller.Response;
import top.tobycold.domain.User;
import top.tobycold.service.LoginService;

import javax.servlet.http.HttpServletRequest;


@RestController
public class Login {
    /**
     * 登录的接口
     */

    @Autowired
    private LoginService loginService;

    Response response = new Response();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(User user) {
        System.out.println(user.toString());
        if (loginService.login(user)) {
            Jwts.builder();

            return response.setCode(200).setData("登录成功").setData(null);
        }
        return response.setCode(304).setData("登录失败").setData(null);
    }

    public Response register(User user) {
        if (loginService.register(user)) {

        }
        return response.setCode(304).setData("注册失败").setData(null);
    }


}
