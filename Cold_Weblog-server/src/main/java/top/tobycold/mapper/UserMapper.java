package top.tobycold.mapper;

import org.apache.ibatis.annotations.Select;
import top.tobycold.pojo.UserEntity;

public interface UserMapper {

    /**
     * 根据account查询用户
     * @param account
     * @return
     */
    @Select("select  * from tb_login where username = #{account}")
    UserEntity getByAccount(String account);
}
