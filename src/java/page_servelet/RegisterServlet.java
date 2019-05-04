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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author asus
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String url = "";
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String midName = request.getParameter("midName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String name = lastName + " " + midName + " " + firstName;

        HttpSession session = request.getSession();
        try {
            System.out.println();
            if (email != null) {
                // Chuyen trang
                url = "./page/index.jsp";
                AccountDaoImpl accountDao = new AccountDaoImpl();
                Account account = new Account.AccountBuilder(email).
                        password(password).address(address).name(name)
                        .telephone(telephone).build();
                accountDao.register(account);
                
                String successMessage = "Register successful!";
                session.setAttribute("account", account);
                request.setAttribute("successMessage", successMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            } else {
                url = "./page/register.jsp";
                String errorMessage = "Register failed! Please register again!";

                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("RegisterServlet Failed!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
