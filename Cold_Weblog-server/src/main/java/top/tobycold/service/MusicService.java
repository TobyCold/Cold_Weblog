package top.tobycold.service;

import top.tobycold.dao.Musics;
import top.tobycold.dto.MusicPageDTO;
import top.tobycold.pojo.MusicEntity;

public interface MusicService {
    /**
     * 查询所有音乐
     * @return
     */
    Musics getMusicPage(MusicPageDTO musicPageDTO);

    MusicEntity getMusic(int id);
}
