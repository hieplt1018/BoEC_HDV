/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import dao.ClothesDaoImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Clothes;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class ImageUrl {

    public ArrayList<Clothes> getClothes() throws IOException {
        ArrayList<Clothes> newsList = new ArrayList<>();
     //  String url = "https://yishop.com.vn/danh-muc/ao-so-mi-nu"; //Blouse 4
//        String url = "https://yishop.com.vn/danh-muc/vay-dam"; //Dress 2
//        String url = "https://yishop.com.vn/danh-muc/chan-vay"; //Skirt 1
//          String url = "https://yishop.com.vn/danh-muc/ao-len-thu-dong"; //Sweater 6
//        String url = "https://yishop.com.vn/danh-muc/ao-khoac"; //Jacket 5
        String url = "https://yishop.com.vn/danh-muc/dam-thu-dong"; //Winter Dress 3
        Document document = Jsoup.connect(url).get();

        Elements title = document.getElementsByClass("attachment-shop-thumb");
        Iterator<Element> it = title.iterator();
        Elements image = document.getElementsByClass("attachment-shop-thumb");
        Iterator<Element> itImage = image.iterator();

        while (it.hasNext()) {
            Element aTitle = it.next();
            Element aImage = itImage.next();
            String[] nameText = aImage.attr("alt").split(":");
            String name = nameText[0].trim();
            Random rd = new Random();
            double price = 15 + rd.nextInt(35);
            if(name.equalsIgnoreCase("")) {
                int i = 2000 + rd.nextInt(200);
                name = "DL" + i;
            }
            Clothes clothes = new Clothes.ClothesBuilder().name(name)
                    .image(aImage.attr("src")).categoryId(3).country("Korean")
                    .price(price).size("Free Size").build();
            newsList.add(clothes);
        }
        return newsList;
    }

    public static void main(String[] args) throws IOException {
        ImageUrl imageUrl = new ImageUrl();
        ArrayList<Clothes> newsList = imageUrl.getClothes();
        ClothesDaoImpl clothesDaoImpl= new ClothesDaoImpl();
        
        for (Clothes clothes : newsList) {
            clothesDaoImpl.insert(clothes);
            System.out.println("Title: " + clothes.getName());
            System.out.println("Image" + clothes.getImage());
            System.out.println("Price: " + clothes.getPrice());
        }
    }
}
