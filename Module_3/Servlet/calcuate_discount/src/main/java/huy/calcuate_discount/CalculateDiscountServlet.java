package huy.calcuate_discount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateDiscountServlet", value = "/calculate")
public class CalculateDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String desc = request.getParameter("desc");
        double price = Double.parseDouble(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discountPercent"));
        double discountAmount = price*discount*0.01;
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1> Sản phẩm:"+desc+"</h1>");
        writer.println("<h2>Giá trước khi giảm:"+price+"</h2>");
        writer.println("<h2>Giảm: "+discountAmount+"</h2>");
        writer.println("<h2> Giá sau khi giảm:"+(price - discountAmount)+"</h2>");
        writer.println("</body></html>");
    }
}
