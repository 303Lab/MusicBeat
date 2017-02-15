package com.musicbeat.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.musicbeat.web.model.constant.Constants.SESSION_USER;

/**
 * ${DESCRIPTION}
 *
 * @author windawings
 * @version 1.0.0
 * @time.creation 2017/02/13 11:34
 * @since 1.0.0
 */
public class UserInterceptor implements HandlerInterceptor {

    //拦截前处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        Object sessionObj = request.getSession().getAttribute(SESSION_USER);
        if(sessionObj != null) {
            return true;
        }
        response.sendRedirect(request.getContextPath()
                              + "/#!/login?next=".concat(request.getRequestURI()));
        return false;
    }
    //拦截后处理
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception { }
    //全部完成后处理
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception { }
}