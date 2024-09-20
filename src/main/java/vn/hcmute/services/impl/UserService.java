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
        userDao.insertUser(user);
    }

    @Override
    public boolean registerUser(String username, String password, String fullname, String email, String phone) {
        if(userDao.checkExistEmail(email)){
            return false;
        }
        if(userDao.checkExistPhone(phone)){
            return false;
        }
        if(userDao.checkExistUsername(username)){
            return false;
        }
        userDao.insertUser(new UserModel(username, password, fullname, email, phone, 1));
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean resetPassword(String email, String username, String password) {
        if(userDao.checkExistEmail(email)){
            if(userDao.checkExistUsername(username)){
                userDao.resetPassword(username, password);
                return true;
            }
        }
        return false;
    }


}
