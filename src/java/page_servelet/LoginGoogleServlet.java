/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page_servelet;

import dao.AccountDaoImpl;
import helper.GooglePojo;
import helper.GoogleUtils;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

public class LoginGoogleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginGoogleServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        
        try {
            if (code == null || code.isEmpty()) {
                RequestDispatcher dis = request.getRequestDispatcher("./page/login.jsp");
                dis.forward(request, response);
            } else {
                AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
                AccountDaoImpl acDaocheckEmail = new AccountDaoImpl();
                String accessToken = GoogleUtils.getToken(code);
                GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
                String googleID = googlePojo.getId();
                String email = googlePojo.getEmail();
                if(!acDaocheckEmail.checkEmail(email)){
                    accountDaoImpl.registerGoogle(googleID, email);
                    Account accountGoogle = accountDaoImpl.loginGoogle(email);
                    System.out.println(accountGoogle.getEmail());
                    session.setAttribute("account", accountGoogle);
                    request.setAttribute("username", email);
                    session.setAttribute("user", email);
                } else {
                    System.out.println("Email existed!");
                    Account googleAc = accountDaoImpl.loginGoogle(email);
                    System.out.println(googleAc.getEmail());
                    session.setAttribute("account", googleAc);
                }
                RequestDispatcher dis = request.getRequestDispatcher("./page/index.jsp");
                dis.forward(request, response);
            }
        }catch(Exception ex) {
            System.out.println("LoginGoogleServlet Failed!");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
