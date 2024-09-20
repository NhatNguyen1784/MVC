package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.hcmute.services.IUserService;
import vn.hcmute.services.impl.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = {"/forgot-pass"})
public class ForgotPassController extends HttpServlet {
    IUserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lay dữ liệu từ view
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("newpass");
        String alertMsg = "";

        if(!userService.checkExistEmail(email)) {
            alertMsg = "Email không đúng";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/forgot-pass.jsp").forward(req, resp);

        } else if(!userService.checkExistUsername(username)) {
            alertMsg = "Username không đúng";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/forgot-pass.jsp").forward(req, resp);

        }
        else {
            // userService.updatePass(password)
            alertMsg = "Đổi mật khẩu thành công";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }

    }
}
