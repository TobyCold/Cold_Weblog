package top.tobycold.service;


import top.tobycold.dto.EntityDTO;
import top.tobycold.pojo.UserEntity;

public interface ConsoleService {

    /**
     * 登录
     * @param entityDTO
     */
    UserEntity login(EntityDTO entityDTO, String IP);
    /**
     * 注册
     * @param entityDTO
     */

    void registered(EntityDTO entityDTO, String remoteAddr);
}
