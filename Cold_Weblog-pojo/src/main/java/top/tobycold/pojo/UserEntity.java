package top.tobycold.pojo;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;
    private String username;
    private String sex;
    private String password;
    private String email;
    private String ip;
    private String phone;

}
