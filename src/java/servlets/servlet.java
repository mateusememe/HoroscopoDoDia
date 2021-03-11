package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Horoscopo;

@WebServlet(name = "servlet", urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {
    
    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email, senha;
        email = request.getParameter("email");
        senha = request.getParameter("senha");
        
       
        System.out.println(email + senha + "signo: "+ Horoscopo.buscaSigno("2001-12-30"));
        //validação
        if(validar(email,senha)){
            HttpSession session = request.getSession(true);
            session.setAttribute("email", email);
            session.setAttribute("senha", senha);
            response.sendRedirect("horoscopo.jsp");
        }            
        else
            response.sendRedirect(".");
        
        return;
    }
    
    private boolean validar(String email, String senha){
        Matcher matcher = pattern.matcher(email);
        if(email.length()> 0 && senha.length() > 0){
            if(matcher.matches()){
                String sub = email.substring(0, email.indexOf("@"));
                String fraseInvertida = new StringBuilder(sub).reverse().toString();
                return senha.equalsIgnoreCase(fraseInvertida);
            }   
        }
        
        return false;
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
