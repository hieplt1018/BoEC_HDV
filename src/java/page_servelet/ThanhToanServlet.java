/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page_servelet;

import dao.BillDaoImpl;
import dao.ChiTietHoaDonDaoImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Bill;
import model.Cart;
import model.ChiTietHoaDon;
import model.Clothes;

/**
 *
 * @author Linh
 */
public class ThanhToanServlet extends HttpServlet {

    private BillDaoImpl billDao = new BillDaoImpl();
    private ChiTietHoaDonDaoImpl cthdDao = new ChiTietHoaDonDaoImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("user"));
        long cartID = (long) session.getAttribute("cartid");
        float total = (float) session.getAttribute("total");
        Cart cart = (Cart) session.getAttribute("cart");
        
        HashMap<Long, Clothes> list = cart.getList();
        for (Entry<Long, Clothes> entry : list.entrySet()) {
            Long key = entry.getKey();
            Clothes value = entry.getValue();
            
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(cartID, value.getClothId(), value.getQuantity());
            cthdDao.themChiTietHD(chiTietHoaDon);
        };
        
        
        try {
            Account account = (Account) session.getAttribute("account");
            int accountID = account.getID();
            System.out.println("Account ID:" + accountID);
            System.out.println(accountID);
            Bill bill = new Bill(cartID, accountID, total);
            billDao.insertBill(bill);
            
            String url = "";
            url = "/page/message.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
