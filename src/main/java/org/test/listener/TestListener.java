package org.test.listener;

import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.apache.commons.logging.Log;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// not use
public class TestListener implements ServletContextListener {
    private Log log = LogFactory.getLog(TestListener.class);
    private ContextLoader contextLoader;

    protected ContextLoader createContextLoader() {
        return new ContextLoader();
    }
    public ContextLoader getContextLoader() {
        return this.contextLoader;
    }
    public void contextInitialized(ServletContextEvent event) {
        //the same as web.xml display name
        log.info("start ini context"+event.getServletContext().getServletContextName());
        this.contextLoader = createContextLoader();
        this.contextLoader.initWebApplicationContext(event.getServletContext());
    }

    public void contextDestroyed(ServletContextEvent event) {
        log.info("destroy ini context");
        if (this.contextLoader != null) {
            this.contextLoader.closeWebApplicationContext(event.getServletContext());
        }
    }
}
