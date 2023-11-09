package top.tobycold.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.tobycold.domain.User;

import java.util.List;


@Mapper
public interface LoginDao {

    @Select("select * from tb_login where username = #{username} AND password = #{password}")
    User login(User user);
    @Select("select * from tb_login")
    List<User> findAll();

    @Insert("insert into tb_login set username=(#{username},password=#{password})")
    void register(String username, String password);
}
