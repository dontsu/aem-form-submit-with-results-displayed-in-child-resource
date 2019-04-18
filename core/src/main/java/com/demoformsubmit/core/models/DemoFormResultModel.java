package com.demoformsubmit.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.annotation.PostConstruct;
import java.util.Enumeration;

@Model(adaptables = { SlingHttpServletRequest.class})
public class DemoFormResultModel {

    @Self
    SlingHttpServletRequest request;

    private String rawJson;

    @PostConstruct
    protected void init() {

        Enumeration<?> attrNames = this.request.getAttributeNames();
        while (attrNames.hasMoreElements()) {
            String attr = (String) attrNames.nextElement();

            if (attr.equals("jsonResponse")) {
                this.setRawJson((String) request.getAttribute(attr));
            }
        }
    }

    public void setRawJson(String json) {
        this.rawJson = json;
    }

    public String getRawJson() {
        return rawJson;
    }
}
