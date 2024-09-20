package vn.hcmute.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String alertMsg = "";
        if(session != null) {
            session.invalidate();
            alertMsg = "Loggout thành công";
        }
        else {
            alertMsg = "You are not logged in.";
        }
        req.setAttribute("alertMsg", alertMsg);
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }
}
