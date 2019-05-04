/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page_servelet;

import dao.AccountDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author asus
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password"); 
        String rememberMe = request.getParameter("remember");
        System.out.println(rememberMe);
        String url = "";
        HttpSession session = request.getSession();
        try {
            AccountDaoImpl accountDAO = new AccountDaoImpl();
            Account account = accountDAO.login(username, password);
            System.out.println(account);
            if(account != null){
                url = "./page/index.jsp";
                session.setAttribute("account", account);
                request.setAttribute("username", username);
                session.setAttribute("user", username);
                if (request.getParameter("remember") != null) {
                    String remember = request.getParameter("remember").trim();
                    System.out.println("remember : " + remember);
                    Cookie cUserName = new Cookie("cookuser", username);
                    Cookie cPassword = new Cookie("cookpass", password);
                    Cookie cRemember = new Cookie("cookrem", remember);
                    cUserName.setMaxAge(60 * 60 * 24 * 15);     //15 days
                    cPassword.setMaxAge(60 * 60 * 24 * 15);
                    cRemember.setMaxAge(60 * 60 * 24 * 15);
                    response.addCookie(cUserName);
                    response.addCookie(cPassword);
                    response.addCookie(cRemember);
                } 
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
            else{
                url = "./page/login.jsp";
                String errorMessage = "Wrong username or password!";
 
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher =  request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
        }catch(Exception ex) {
            System.out.println("LoginServlet Failed!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
