package vn.hcmute.dao;

import vn.hcmute.models.UserModel;

import java.util.List;

public interface IUserDao {
    List<UserModel> findAll();

    UserModel findById(int id);

    UserModel findByUserName(String username) throws Exception;

    void insertUser(UserModel user);

    boolean checkExistEmail(String email);

    boolean checkExistPhone(String phone);

    boolean checkExistUsername(String username);

    void resetPassword(String username, String password);
}
