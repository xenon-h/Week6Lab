/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author 759005
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            if (items == null) {
                items = new ArrayList<>();
                session.setAttribute("items", items);
            }

            request.setAttribute("message", "");
            if (request.getAttribute("action") != null && request.getAttribute("action").equals("logout")) {
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else if (session.getAttribute("username") != null) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("message", "action could not be performed");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");

            request.setAttribute("message", "");

            if (action != null && action.equals("deleteItem")) {
                if (!items.isEmpty()) {
                    items.remove(request.getParameter("item"));
                }
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            } else if (action != null && action.equals("register")) {

                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            } else if (request.getAttribute("action") != null && request.getAttribute("action").equals("logout")) {
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            } else {
                
                String username = request.getParameter("username");
                if (username!=null) {
                session.setAttribute("username", username);                    
                }
                if (items == null) {
                    items = new ArrayList<>();
                    session.setAttribute("items", items);
                }
                String item = request.getParameter("itemname");
                items.add(item);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("message", "action could not be performed");
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }
    }
}
