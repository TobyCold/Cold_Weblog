package top.tobycold.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dao.Musics;
import top.tobycold.dto.MusicPageDTO;
import top.tobycold.mapper.MusicMapper;
import top.tobycold.pojo.MusicEntity;
import top.tobycold.service.MusicService;

import java.util.List;

@Service
public class MusicServiceImpl  implements MusicService{
    @Autowired
    MusicMapper musicMapper;

    /**
     * 查询所有音乐
     * @return
     */
    public Musics getMusicPage(MusicPageDTO musicPageDTO) {
        List<MusicEntity> musicEntity = musicMapper.getMusicPage();
        return null;
    }

    /**
     * 根据ID查询单首音乐
     * @param id
     * @return
     */
    public MusicEntity getMusic(int id) {
        return null;
    }
}
