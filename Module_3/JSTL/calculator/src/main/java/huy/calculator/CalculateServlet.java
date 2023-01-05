package huy.calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double fOperand = Double.parseDouble(request.getParameter("fOperand"));
        double sOperand = Double.parseDouble(request.getParameter("sOperand"));
        String operator = request.getParameter("operator");
        double result = 0;
        String exception = "";
        switch (operator){
            case "add" -> result = fOperand+sOperand;
            case "min" -> result = fOperand - sOperand;
            case "div" -> {
                try{
                    result = fOperand/sOperand;
                }catch (Exception e){
                    exception= e.getMessage();
                }
            }
            case "mul" -> result = fOperand*sOperand;
        }
        request.setAttribute("exception",exception);
        request.setAttribute("result",result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
}
