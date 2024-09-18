package vn.hcmute.services;

import vn.hcmute.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);

    UserModel findByUserName(String username);
}
