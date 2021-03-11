package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Horoscopo;

@WebServlet(name = "recuperaHoroscopo", urlPatterns = {"/recuperaHoroscopo"})
public class recuperaHoroscopo extends HttpServlet {
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String signo, subL, image, previsao;
        signo = Horoscopo.buscaSigno(request.getParameter("dtnasc"));
        
        System.out.println(request.getServletContext().getRealPath("") + "horoscopo.txt");
        
        subL = Horoscopo.buscaPrevisaoImagem(signo, request.getServletContext().getRealPath("") + "horoscopo.txt");
        image = subL.substring(0,subL.indexOf("#"));
        previsao = subL.substring(subL.indexOf("#") +1 );            
        try (PrintWriter out = response.getWriter()) {
            out.println("<br><h1>"+ signo.toUpperCase() +"</h1>");
            out.println("<div class= 'forecast'>");
                out.println("<a href='#' id='focusIMG'></a><img id='imgSigno' src = 'img\\" +  image + "'/>");
                out.println("<p class='centered'>"+ previsao +"</p>");
            out.println("</div>");
        }
        catch(Exception e){
            System.out.println("Não consegui pegar a previsão -> Erro: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
