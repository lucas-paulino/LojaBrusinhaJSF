package session;

import beans.LojaBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import objetos.Produto;
import objetos.Usuario;

public class SessionFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {  }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;        
        String uri = httpServletRequest.getRequestURI();
        HttpSession session = httpServletRequest.getSession();
        
        if(uri != null && uri.endsWith("perfil.xhtml")){
            if(session.getAttribute("user") == null || !(session.getAttribute("user") instanceof Usuario)){
                request.getRequestDispatcher("/faces/index.xhtml").forward(request, response);
            }else{
                chain.doFilter(request,response);
                return;
            }
        }else if(uri != null && uri.endsWith("index.xhtml")){
            if(session.getAttribute("user") == null || !(session.getAttribute("user") instanceof Usuario)){
                chain.doFilter(request,response);
            }else{
                request.getRequestDispatcher("/faces/perfil.xhtml").forward(request, response);                
                return;
            }
        }else if(uri != null && uri.endsWith("loja.xhtml")){
            //SessionContext.getInstance().setAttribute("listaProdutos", produtos)
            LojaBean loja = new LojaBean();
            
            List<Produto> produtos = loja.gerarProduto();
            
            session.setAttribute("listaProdutos",produtos);
            chain.doFilter(request,response);
            return;
        }else{
            chain.doFilter(request,response);
            return;
        }

    }

    @Override
    public void destroy() { }  
}
