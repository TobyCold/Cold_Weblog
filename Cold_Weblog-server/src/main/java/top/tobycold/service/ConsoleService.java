package top.tobycold.service;


import top.tobycold.dto.EntityDTO;

public interface ConsoleService {

    /**
     * 登录
     * @param entityDTO
     */
    public String login(EntityDTO entityDTO, String IP);
    /**
     * 注册
     * @param entityDTO
     */

    boolean registered(EntityDTO entityDTO, String remoteAddr);
}
