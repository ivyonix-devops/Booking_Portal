package com.example.Transverra.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger implements ApplicationListener<WebServerInitializedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(StartupLogger.class);

    private final Environment env;

    public StartupLogger(Environment env) {
        this.env = env;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        int actualPort = event.getWebServer().getPort();
        String serverPortProp = env.getProperty("server.port", "<not set>");
        String[] profiles = env.getActiveProfiles();
        String activeProfiles = (profiles == null || profiles.length == 0) ? "<none>" : String.join(",", profiles);

        String datasourceUrl = env.getProperty("spring.datasource.url", "<not set>");
        String datasourceUser = env.getProperty("spring.datasource.username", "<not set>");
        String datasourceDriver = env.getProperty("spring.datasource.driver-class-name", "<not set>");

        logger.info("Application started. activeProfiles=[{}], server.port(property)=[{}], actualPort=[{}]",
                activeProfiles, serverPortProp, actualPort);

        logger.info("Datasource (masked): url=[{}], username=[{}], driver=[{}]",
                maskDatasourceUrl(datasourceUrl), datasourceUser, datasourceDriver);
    }

    private String maskDatasourceUrl(String url) {
        if (url == null) return "<not set>";
        // mask jdbc urls that include user:pass@host or password=... patterns
        // 1) mask user:pass@ (e.g. jdbc:mysql://user:pass@host:3306/db)
        String masked = url.replaceAll("(?<=//)[^/@]*@", "****@");
        // 2) mask password=... in query params
        masked = masked.replaceAll("(?i)(password=)[^&]*", "$1****");
        return masked;
    }
}

