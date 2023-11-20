package top.tobycold.controller.console;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.dao.Response;
import top.tobycold.dto.EntityDTO;
import top.tobycold.service.ConsoleService;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("console")
@Api("管理后台相关接口")
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
        String token = consoleService.login(entityDTO, request.getLocalAddr());
        return Response.seccess(token);
    }

    /**
     * 注册功能
     * TODO 待完成
     * @param entityDTO
     * @param request
     * @return
     */
    @RequestMapping(value = "registered", method = RequestMethod.POST)
    public Response<?> registered(EntityDTO entityDTO, HttpServletRequest request) {

        return Response.seccess();
    }

}

