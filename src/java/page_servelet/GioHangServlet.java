/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page_servelet;

import dao.ClothesDaoImpl;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Clothes;

/**
 *
 * @author Linh
 */
public class GioHangServlet extends HttpServlet {
       
    private ClothesDaoImpl clothesDao = new ClothesDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        int msp = Integer.parseInt(request.getParameter("ID"));
        long key = Long.parseLong(request.getParameter("ID"));
        String command = request.getParameter("command");
        ArrayList<Long> listBuy = null;
        String url = "/page/cart.jsp";
        try {
            listBuy = (ArrayList<Long>) session.getAttribute("cartID");
            long idBuy = 0;
            if (request.getParameter("cartID") != null) {
                idBuy = Long.parseLong(request.getParameter("cartID"));
            }
            Clothes clothes = clothesDao.getClothesDetails(msp);
            System.out.println("ClothesID: " + clothes.getClothId());
            System.out.println("cartID: " + idBuy);
            
            switch (command) {
                case "insert":
                    if (listBuy == null) {
                        listBuy = new ArrayList<>();
                        session.setAttribute("cartID", listBuy);
                    }
                    if (listBuy.indexOf(idBuy) == -1) {
                        cart.insertToCart(key, clothes);
                        listBuy.add(idBuy);
                    }
                    url = "/page/cart.jsp";
                    break;
                
                case "plus":
                    if (listBuy == null) {
                        listBuy = new ArrayList<>();
                        session.setAttribute("cart", listBuy);
                    }
                    if (listBuy.indexOf(idBuy) == -1) {
                        cart.insertToCart(key, clothes);
                        listBuy.add(idBuy);
                    }
                    url = "/page/cart.jsp";
                    break;
                   
                case "sub":
                    if (listBuy == null) {
                        listBuy = new ArrayList<>();
                        session.setAttribute("cart", listBuy);
                    }
                    if (listBuy.indexOf(idBuy) == -1) {
                        cart.subToCart(key, clothes);
                        listBuy.add(idBuy);
                    }
                    url = "/page/cart.jsp";
                    break;
                   
                case "remove":
                    cart.removeToCart(key);
                    url = "/page/cart.jsp";
                    break;
                default:
                    break;
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Loi Gio hang Servlet!");
        }
    }
}
