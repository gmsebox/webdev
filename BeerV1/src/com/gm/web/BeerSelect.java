package com.gm.web;

import com.gm.model.*;
import java.io.*;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerSelect
 */
@WebServlet("/BeerSelect")
public class BeerSelect extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Color Selected:").append(request.getParameter("Color").toString());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //instantiate a new expert object
        //pass in the color
        //return the result into response object.
        String input = request.getParameter("Color").toString();
        BeerExpert beerExp = new BeerExpert();
        List<String> results = beerExp.getBrands(input);
       // response.setContentType("text/html");
        //PrintWriter out = response.getWriter();
        //out.println("Beer Selection Advice<br>");
        
        //for (Iterator<String> iterator = results.iterator(); iterator.hasNext();) {            
          //  out.println("<br>Try: "+(String) iterator.next());           
        //}
        
        request.setAttribute("styles", results);
        RequestDispatcher view =request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
       
        
    }

}
