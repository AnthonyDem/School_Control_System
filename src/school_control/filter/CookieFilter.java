package school_control.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import school_control.beans.Teacher;
import school_control.utils.DBUtils;
import school_control.utils.MyUtils;

@WebFilter(filterName = "cookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter{
	public CookieFilter() {
		
	}
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	@Override 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		Teacher userlnSession = MyUtils.getLoginedUser(session);
		
		if (userlnSession != null) {
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
			chain.doFilter(request, response);
			return;
		}
		
		Connection conn = MyUtils.getStoredConnection(request);
		
		String checked = (String) session.getAttribute("COOKIE_CHECKED");
		if (checked == null && conn != null) {
			String userName = MyUtils.getUserNamelnCookie(req);
			try {
				Teacher user = DBUtils.findUser(conn, userName);
				MyUtils.storeLoginedUser(session, user);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
			}
		chain.doFilter(request, response);
		}
	}
