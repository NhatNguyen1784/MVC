package vn.hcmute.dao;

import vn.hcmute.models.UserModel;

import java.util.List;

public interface IUserDao {
    List<UserModel> findAll();

    UserModel findById(int id);

    UserModel findByUserName(String username) throws Exception;

    void insert(UserModel user);
}
