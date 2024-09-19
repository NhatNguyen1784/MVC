package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.hcmute.services.IUserService;
import vn.hcmute.services.impl.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    // goi tat ca cac ham cua service
    IUserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String alertMsg = "";
        // kiem tra input
        if(userService.checkExistUsername(username)) {
            alertMsg = "Username đã tồn tại";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("views/register.jsp").forward(req, resp);
        }
        if(userService.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("views/register.jsp").forward(req, resp);
        }
        if(userService.checkExistPhone(phone)) {
            alertMsg = "phone đã tồn tại";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("views/register.jsp").forward(req, resp);
        }

        boolean resultRegister = userService.registerUser(username, password, fullname, email, phone);
        if(resultRegister) {
            alertMsg = "Đăng kí thành công";
            req.setAttribute("alertMsg", alertMsg);
            resp.sendRedirect(req.getContextPath() + "/login");
        }
        else {
            alertMsg = "Error";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("views/register.jsp").forward(req, resp);
        }

    }
}
