package com.demoformsubmit.core.servlets;

import com.demoformsubmit.core.services.DemoService;
import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.wrappers.SlingHttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

@SlingServlet(paths = "/bin/demo/search")
public class DemoSubmitFormServlet extends SlingSafeMethodsServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoSubmitFormServlet.class);
    @Reference
    DemoService demoService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
            SlingHttpServletRequestWrapper requestWrapper = new SlingHttpServletRequestWrapper(request) {
                public String getMethod() {
                    return "GET";
                }
            };
            String redirectPage =  request.getParameter("redirect");
            RequestDispatcher dispatcher = request.getRequestDispatcher(redirectPage + ".html");
            if(request.getRequestParameterList().size() > 0) {

                String emailParam = request.getParameter("email1");
                if (StringUtils.isNotBlank(emailParam)) {


                    request.getSession().setAttribute("jsonResponse", demoService.search(emailParam).toString());
                   dispatcher.include(requestWrapper, response);
                }
            } else {
                LOGGER.error("The list of emails passed to the call is empty");
            }
        } catch (Exception ex) {
            LOGGER.error("ExceptionMessage :: " + ex.getMessage() + " :: ExceptionCause :: " + ex.getCause());
        }
    }
}
