package vn.hcmute.services.impl;

import vn.hcmute.dao.IUserDao;
import vn.hcmute.dao.impl.UserDaoImpl;
import vn.hcmute.models.UserModel;
import vn.hcmute.services.IUserService;

public class UserService implements IUserService {
    // lấy toàn bộ hàm trong tầng DAO của user
    IUserDao userDao = new UserDaoImpl();
    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.findByUserName(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public UserModel findByUserName(String username) {
        try {
            return userDao.findByUserName(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertUser(UserModel user) {

    }

    @Override
    public boolean registerUser(String username, String password, String email, String phone, String fullname) {
        return false;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return false;
    }


}
