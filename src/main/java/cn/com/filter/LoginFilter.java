package cn.com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <pre>
 * Filename      :  LoginFilter
 * Package       :  cn.com.filter
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2019年12月2019/12/17日
 * </pre>
 *
 * @author : yangdong.jia
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        if(session.getAttribute("LOGIN_USER")==null){
            // 没有登录
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else{
            // 已经登录，继续请求下一级资源（继续访问）
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
