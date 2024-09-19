package vn.hcmute.services;

import vn.hcmute.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);

    UserModel findByUserName(String username);

    void insertUser(UserModel user);

    boolean registerUser(String username, String password, String email, String phone, String fullname);

    boolean checkExistEmail(String email);

    boolean checkExistPhone(String phone);

    boolean checkExistUsername(String username);
}
