package com.barco.imrh.emailer.view;

import com.barco.imrh.enums.TemplateType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author Nabeel Ahmed
 */
@Component
public class VelocityManager {

    private Logger logger = LogManager.getLogger(VelocityManager.class);
    private Template template;
    private VelocityEngine engine;
    /*  create a context and add data */
    private VelocityContext context;
    /* now render the template into a StringWriter */
    private StringWriter writer;

    @PostConstruct
    public void init() {
        logger.info("+================Velocity-Start====================+");
        this.engine = getEngine();
        this.engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        this.engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        this.engine.init();
        logger.info("+================Velocity-End====================+");
    }

    public VelocityManager() { }

    public String getResponseMessage(TemplateType templateType, Map<String, Object> object) {
        String responseMessage = null;
        this.setWriter(new StringWriter());
        this.setContext(new VelocityContext());
        if (templateType.equals(TemplateType.TEST_TEMPLATE)) {
            logger.info("Request Content :- " + object);
            this.context.put("request", object);
            responseMessage = this.getWriterResponse(templateType).toString();
        }
        return responseMessage;
    }

    private StringWriter getWriterResponse(TemplateType templateType) throws NullPointerException {
        Template template = this.getTemplate(templateType);
        if (template != null) {
            template.merge(this.getContext(), this.getWriter());
            logger.info("Response Content :- " + this.getWriter().toString()
                  .replaceAll("\\s+",""));
            return this.getWriter();
        }
        throw new NullPointerException("Template Not Found");
    }

    public Template getTemplate(TemplateType templateType) {
        switch (templateType) {
            case TEST_TEMPLATE:
                this.template = this.engine.getTemplate(
                    templateType.getTemplatePath());
                break;
        }
        return template;
    }
    private VelocityEngine getEngine() {
        return new VelocityEngine();
    }

    public VelocityContext getContext() {
        return context;
    }
    public void setContext(VelocityContext context) {
        this.context = context;
    }

    public StringWriter getWriter() {
        return writer;
    }
    public void setWriter(StringWriter writer) {
        this.writer = writer;
    }

}
