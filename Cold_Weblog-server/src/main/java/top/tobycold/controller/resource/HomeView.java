package top.tobycold.controller.resource;


import cn.hutool.core.io.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.tobycold.dao.Response;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("data")
@Slf4j
@Api("主页资源请求接口")
public class HomeView {
    @Value("${main.path}")
    private String PathMain;
    @GetMapping("{data}/{name}")
    @ApiOperation("图片请求")
    public byte[] getImage(@PathVariable(name = "data") String data, @PathVariable(name = "name") String name,HttpServletRequest request, HttpServletResponse response){
        log.info("IP:{} -> 端发起请求图片资源,图片时间:{}, 图片名称:{}",request.getLocalAddr(), data, name);
//        byte[] bytes = FileUtil.readBytes(PathMain + data + "//" + name);
//        response.setContentType("image/jpeg");
//        response.setContentLength(bytes.length);
//        return bytes;
        return null;
    }
    @GetMapping("logo")
    @ResponseBody
    public void getLogo(HttpServletResponse response) throws IOException {
        byte[] bytes = FileUtil.readBytes("D:\\weblog\\20230520\\logo.jpg");
        response.setStatus(403);
        response.setContentLength(bytes.length);
        response.setContentType("image/jpeg");

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
    }
}
