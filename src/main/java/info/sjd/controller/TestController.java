package info.sjd.controller;

import info.sjd.model.User;
import info.sjd.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String login = (String) req.getAttribute("login");
        String pass = (String) req.getAttribute("pass");

        User user = UserService.findUserByLogin(login);

        if (user == null || !user.getPass().equals(pass)){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/wrong.jsp");
            dispatcher.forward(req, resp);
        } else{
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/good.jsp");
            dispatcher.forward(req, resp);


        }


    }
}
