package top.tobycold.dao;

import lombok.Data;
import top.tobycold.pojo.MusicEntity;

import java.util.List;

@Data
public class Musics {
    private long total;
    private List<MusicEntity> musics;
}
