package top.tobycold.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tobycold.dao.LoginDao;
import top.tobycold.domain.User;
import top.tobycold.service.LoginService;



@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;
    public boolean login(User user) {
        User users = loginDao.login(user);

        if (users == null) {
            return false;
        }
        return true;
    }

    public boolean register(User user) {
        loginDao.register(user.getUsername(), user.getPassword());
        return true;
    }
}
