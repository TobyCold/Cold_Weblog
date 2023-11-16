package top.tobycold.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import top.tobycold.domain.User;

public interface LoginService {

    /**
     * 登录
     * @param user
     */
    public boolean login(User user);
    /**
     * 注册
     * @param user
     */

    public boolean register(User user);
}
