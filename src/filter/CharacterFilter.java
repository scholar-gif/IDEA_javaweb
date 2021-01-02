package filter;

import java.io.IOException;







import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter {
	private static String encoding;
	@Override
	public void destroy(){
		// TODO Auto-generated method stub
	}
	
	@Override
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		chain.doFilter(request,response);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException{
		// TODO Auto-generated method stub
		encoding=config.getInitParameter("encoding");
	}

	
}
