package session;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import objetos.Usuario;

public class SessionFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {  }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;        
        String uri = httpServletRequest.getRequestURI();
        System.out.println("URL:" + uri);  
        if(uri.endsWith(".css")|| uri.endsWith(".jpg")|| uri.endsWith(".png")){
            chain.doFilter(request,response);
            return;
        }
        if (uri != null
                && (uri.equals("/JSFSession/")
                || uri.equals("/JSFSession/index.xhtml")
                || uri.equals("/JSFSession/faces/index.xhtml"))) {        
            System.out.println("\n SessionFilter: Esse recurso é livre de sessão \n");
            chain.doFilter(request, response);            
        } else {
            HttpSession session = httpServletRequest.getSession();
            if (session.getAttribute("user") == null || !(session.getAttribute("user") instanceof Usuario)) {
                System.err.println("\n SessionFilter: Você não tem acesso a esse recurso restrito \n");
                request.setAttribute("mensagem", "Você não tem permissão para acessar este recurso");
                request.getRequestDispatcher("/faces/index.xhtml").forward(request, response);
            } else {
                System.out.println("\n SessionFilter: Você tem acesso a esse recurso restrito \n");
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() { }  
}
