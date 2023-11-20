package top.tobycold.service.impl;

import cn.hutool.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.admin.JwtConfig;
import top.tobycold.dto.EntityDTO;
import top.tobycold.mapper.UserMapper;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.ConsoleService;

import java.util.Date;


@Service
public class ConsoleServiceImpl implements ConsoleService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param entityDTO
     * @return
     */

    public String login(EntityDTO entityDTO, String IP) {
        UserEntity loginUserEntity = userMapper.getByAccount(entityDTO.getAccount());
        if (!loginUserEntity.getPassword().equals(entityDTO.getPossword())) {
            return null;
        }
        String token = JWT.create()
                .setNotBefore(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))   //两个小时
                .setKey(JwtConfig.TOKEN_KEY.getBytes())
                .setPayload("id", loginUserEntity.getId())
                .sign();
        return token;
    }

    /**
     * 注册
     * @param entityDTO
     * @return
     */
    @Override
    public boolean registered(EntityDTO entityDTO, String remoteAddr) {
        try {
            UserEntity user = userMapper.getByAccount(entityDTO.getAccount());

        }catch (Exception e){

        }

        return false;
    }
}
