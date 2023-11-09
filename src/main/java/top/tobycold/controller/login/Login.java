package top.tobycold.controller.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.controller.Response;
import top.tobycold.domain.User;
import top.tobycold.service.LoginService;


@RestController
public class Login {
    /**
     * 登录的接口
     */

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(User user) {
        System.out.println(user.toString());
        if (loginService.login(user)) {
            return new Response(200, "登录成功", null);
        }
        return new Response(304, "登录失败", null);
    }

    public Response register(User user) {
        if (loginService.register(user)) {

        }
        return new Response(304, "注册失败", null);
    }


}
