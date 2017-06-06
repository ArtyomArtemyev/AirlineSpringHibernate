package by.netcracker.artemyev.filter;


import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.enumeration.RoleType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DispatcherSecurityFilter implements Filter {
    private FilterConfig filterConfig;
    private final String REDIRECT_PAGE = "/WEB-INF/view/authorization.jsp";
    private final String SESSION_ATTRIBUTE = "user";

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        filterConfig = fConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest objHttpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = objHttpServletRequest.getSession();
        User user = (User) httpSession.getAttribute(SESSION_ATTRIBUTE);
        if(user != null && user.getRole().getRoleType().equals(RoleType.DISPATCHER)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else {
            ServletContext ctx = filterConfig.getServletContext();
            RequestDispatcher dispatcher = ctx.getRequestDispatcher(REDIRECT_PAGE);
            dispatcher.forward(servletRequest, servletResponse);
            return;
        }
    }

    @Override
    public void destroy() {
    }
}
