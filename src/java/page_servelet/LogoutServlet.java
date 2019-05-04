/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page_servelet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cUserName = new Cookie("cookuser", null);
        Cookie cPassword = new Cookie("cookpass", null);
        Cookie cRemember = new Cookie("cookrem", null);
        cUserName.setMaxAge(0);
        cPassword.setMaxAge(0);
        cRemember.setMaxAge(0);
        response.addCookie(cUserName);
        response.addCookie(cPassword);
        response.addCookie(cRemember);
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        RequestDispatcher requestDispatcher
                = request.getRequestDispatcher("/page/index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
