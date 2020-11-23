package com.policeman.web.filter;

import com.policeman.web.pojo.BaseAdminUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Title: FormFilter
 * @Description:
 * @version: 1.0
 */
public class FormFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);

        // If isAuthenticated is false, it proves that you are not logged in, and isRememberd is true
        // It turns out that you didn’t log in and came in directly through the remember me function.
        if (!subject.isAuthenticated() && subject.isRemembered()) {

            // Get the session to see if it is empty
            Session session = subject.getSession(true);

            // Check whether the session attribute is currently empty
            if (session.getAttribute("userName") == null) {
                // Initialize if it is empty
                BaseAdminUser user = (BaseAdminUser)subject.getPrincipal();
                //Save user data
                session.setAttribute("userName", user.getSysUserName());
            }
        }

        // This method originally only returned subject.isAuthenticated() now we add subject.isRemembered()
        // Make it compatible with remember
        return subject.isAuthenticated() || subject.isRemembered();
    }

}
