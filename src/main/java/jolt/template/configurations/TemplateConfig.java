package jolt.template.configurations;

import io.github.t1willi.injector.annotation.Configuration;
import io.github.t1willi.template.TemplateConfiguration;
import io.github.t1willi.template.engines.FreemarkerTemplateEngine;

@Configuration
public final class TemplateConfig extends TemplateConfiguration {

    @Override
    public void configure() {
        setTemplateClasspath("/templates"); // Set the template classpath
        setCaching(true); // Enable caching
        setEngine(new FreemarkerTemplateEngine()); // By default, otherwise, a Thymeleaf implementation is also
                                                   // available.
    }
}
