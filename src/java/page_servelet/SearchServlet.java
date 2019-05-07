/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package page_servelet;

import dao.ClothesDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Clothes;

/**
 *
 * @author asus
 */
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        String searchProduct = request.getParameter("searchProduct");
        
        try {
            ClothesDaoImpl clothesDaoImpl = new ClothesDaoImpl();
            List<Clothes> list = clothesDaoImpl.findName(searchProduct);
            session.setAttribute("nameSearch", list);
            request.getRequestDispatcher("./page/search.jsp").forward(request, response);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
    }

}
