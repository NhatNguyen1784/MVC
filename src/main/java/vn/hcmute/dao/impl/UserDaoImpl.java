package vn.hcmute.dao.impl;

import vn.hcmute.configs.DBConnectMySQL;
import vn.hcmute.dao.IUserDao;
import vn.hcmute.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<UserModel> findAll() {
        String query = "SELECT * FROM users";

        List<UserModel> list = new ArrayList<>();
        try {
            conn = getDatabaseConnection(); // ket noi Database
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            // next từng dòng tới cuối bảng
            while (rs.next()) {
                list.add(new UserModel(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("roleid")));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel findById(int id) {
        try {
            String query = "SELECT * FROM users WHERE id = ?";
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRoleid(rs.getInt("roleid"));
                // chua co rang buoc nên username co thể trùng nên sài list để chứa các user
                // nếu có ràng buộc thì return user
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel findByUserName(String username) {

        try {
            String query = "SELECT * FROM users WHERE username = ?";
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs  = ps.executeQuery();
            while(rs.next()){
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRoleid(rs.getInt("roleid"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertUser(UserModel user) {
        try {
            String query = "INSERT INTO users (username, password, fullname, email, phone) VALUES (?, ?, ?, ?, ?)";
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean flag = false;
        try {
            String query = "SELECT * FROM users WHERE email = ?";
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()){
                flag = true;
            }
            ps.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        boolean flag = false;
        try {
            String query = "SELECT * FROM users WHERE phone = ?";
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()){
                flag = true;
            }
            ps.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean checkExistUsername(String username) {
        boolean flag = false;
        try {
            String query = "SELECT * FROM users WHERE username = ?";
            conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()){
                flag = true;
            }
            ps.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args) throws Exception {
        // test findAll
//        UserDaoImpl userDao = new UserDaoImpl();
//        List<UserModel> list = userDao.findAll();
//        for (UserModel um : list){
//            System.out.println(um);
//        }
        // test findByUserName
//        IUserDao userDao = new UserDaoImpl();
//        System.out.println(userDao.findByUserName("user1"));
        // test findByID
        IUserDao userDao = new UserDaoImpl();
        System.out.println(userDao.findById(1));
    }
}
