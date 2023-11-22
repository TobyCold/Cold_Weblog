package top.tobycold.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.tobycold.dao.Musics;
import top.tobycold.dao.Response;
import top.tobycold.dto.MusicPageDTO;
import top.tobycold.service.MusicService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/cold/music")
@Api(tags = "音乐功能接口")
@Slf4j
public class MusicController {
    @Autowired
    MusicService musicService;
    @Value("${main.path}")
    private String musicPath;
    @PostMapping
    @ApiOperation("获得音乐集合")
    public Response<Musics> getMusicPage(MusicPageDTO musicPageDTO){
        log.info("请求音乐页码和总数为：{}", musicPageDTO);
        Musics musicPage = musicService.getMusicPage(musicPageDTO);
        return Response.success("获得音乐集合成功", musicPage);
    }
    @GetMapping("{id}")
    public Response<Object> getMusic(@PathVariable int id, HttpServletResponse httpServletResponse) throws IOException {
        log.info("请求的音乐id为：{}", id);
//        MusicEntity music = musicService.getMusic(id);
//        String musicPath = this.musicPath + music.getCreateTime() + "//" + music.getName();
//        httpServletResponse.setHeader("Content-Disposition", "inline;filename=music.mp3");
//        return FileUtil.readBytes(musicPath);
        return Response.success();
    }
}
