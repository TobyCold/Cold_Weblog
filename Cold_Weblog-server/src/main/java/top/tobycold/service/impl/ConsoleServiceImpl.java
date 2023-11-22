package top.tobycold.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dto.EntityDTO;
import top.tobycold.mapper.UserMapper;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.ConsoleService;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param entityDTO
     * @return
     */

    public UserEntity login(EntityDTO entityDTO, String IP) {
        return userMapper.getByAccount(entityDTO.getAccount());

    }

    /**
     * 注册
     * @param entityDTO
     * @return
     */
    public void registered(EntityDTO entityDTO, String remoteAddr) {


    }
}
