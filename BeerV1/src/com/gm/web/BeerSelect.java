package src.com.gm.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.gm.model.BeerExpert;

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

        String input = request.getParameter("Color").toString();
        BeerExpert beerExp = new BeerExpert();
        List<String> results = beerExp.getBrands(input);

        request.setAttribute("styles", results);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);       
        
    }

}
