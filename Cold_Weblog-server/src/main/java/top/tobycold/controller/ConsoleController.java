package top.tobycold.controller;

import cn.hutool.jwt.JWT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.tobycold.admin.JwtConfig;
import top.tobycold.dao.Response;
import top.tobycold.dto.EntityDTO;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.ConsoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@RestController
@RequestMapping("console")
@Api(tags = "管理后台相关接口")
@Slf4j
public class ConsoleController {
    /**
     * 登录的接口
     */

    @Autowired
    private ConsoleService consoleService;


    @PostMapping("login")
    @ApiOperation("登录接口")
    public Response<?> login(EntityDTO entityDTO, HttpServletRequest request) {
        log.info("登录用户详细：{} -> ip地址：{}",entityDTO, request.getRemoteAddr());
        UserEntity user = consoleService.login(entityDTO, request.getLocalAddr());
        //TODO 这里可能走异常处理器，不会查询出结果
        log.info("service查询结果UserEntity:{}", user);
        if (user == null || !user.getPassword().equals(entityDTO.getPassword())){
            return Response.error("账号或密码错误", null);
        }
        String token = JWT.create()
                .setNotBefore(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))   //两个小时
                .setKey(JwtConfig.TOKEN_KEY.getBytes())
                .setPayload("id", user.getId())
                .sign();
        return Response.success(token);
    }

    /**
     * 注册功能
     * TODO 待完成
     * @param entityDTO
     * @param request
     * @return tr
     */
    @RequestMapping(value = "registered", method = RequestMethod.POST)
    public Response<?> registered(EntityDTO entityDTO, HttpServletRequest request) {
        
        return Response.success();
    }



}

