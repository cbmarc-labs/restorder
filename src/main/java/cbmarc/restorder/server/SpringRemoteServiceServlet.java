/**
 * 
 */
package cbmarc.restorder.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author Marc
 *
 */
@SuppressWarnings("serial")
public class SpringRemoteServiceServlet extends RemoteServiceServlet {
		
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		
		WebApplicationContextUtils.
				getRequiredWebApplicationContext(getServletContext()).
				getAutowireCapableBeanFactory().
				autowireBean(this);
	}
	
	protected HttpServletRequest getRequest(){
		return getThreadLocalRequest();
	}
	
	protected HttpSession getSession(){
		return getRequest().getSession();
	}
	
}
