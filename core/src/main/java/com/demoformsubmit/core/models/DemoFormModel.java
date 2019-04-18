package com.demoformsubmit.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoFormModel {

    @Inject
    int additionalEmailsCounter;

    public int getAdditionalEmailsCounter() {
        return additionalEmailsCounter;
    }

    public void setAdditionalEmailsCounter(int additionalEmailsCounter) {
        this.additionalEmailsCounter = additionalEmailsCounter;
    }
}
