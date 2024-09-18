package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.hcmute.models.UserModel;
import vn.hcmute.services.IUserService;
import vn.hcmute.services.impl.UserService;
import vn.hcmute.utils.Constant;

import java.io.IOException;

@WebServlet(urlPatterns ={"/login"})
public class LoginController extends HttpServlet {
    // lấy tất cả các hàm của service
    IUserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        // lấy dữ liệu từ form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        boolean isRemember = false;
        // Kiểm tra dữ liệu
        if (remember.equals("on")){
            isRemember = true;
        }
        String alterMsg = "";
        if (username.isEmpty() || password.isEmpty()){
            alterMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alterMsg", alterMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }
        // xử lí bài toán
        UserModel user = service.login(username, password);
        if(user != null){
            HttpSession ss = req.getSession(true);
            ss.setAttribute("account", user);
            if(isRemember){
                saveRemember(resp, username);
            }
            resp.sendRedirect(req.getContextPath() + "/waiting");
        }
        else {
            alterMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alterMsg", alterMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    private void saveRemember(HttpServletResponse resp, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30);
        resp.addCookie(cookie);
    }
}
