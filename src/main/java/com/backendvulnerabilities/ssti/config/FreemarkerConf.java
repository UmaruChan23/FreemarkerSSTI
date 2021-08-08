package com.backendvulnerabilities.ssti.config;

import freemarker.core.TemplateClassResolver;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.Properties;


@Configuration
public class FreemarkerConf {

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setDefaultEncoding("UTF-8");

        Properties properties = new Properties();
        properties.setProperty("template_exception_handler", "rethrow");

        configurer.setTemplateLoaderPath("/templates");
        configurer.setFreemarkerSettings(properties);

        freemarker.template.Configuration configuration = configurer.createConfiguration();

        configuration.setNewBuiltinClassResolver(TemplateClassResolver.SAFER_RESOLVER);
        configuration.setAPIBuiltinEnabled(true);
        configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
        //configuration.setObjectWrapper( new DefaultObjectWrapper() );

        configurer.setConfiguration(configuration);

        return configurer;
    }
}
