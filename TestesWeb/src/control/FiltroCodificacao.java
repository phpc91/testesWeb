package control;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet implementation class FiltroCodificacao
 */
@WebFilter("/*")
public class FiltroCodificacao implements Filter {
       
	/**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws javax.servlet.ServletException {
    	
    }

	/**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, javax.servlet.ServletException { 
    	request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
    	
    }
}
