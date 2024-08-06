package com.fpt.fsa.spring.configs;

import lombok.RequiredArgsConstructor;
//import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@EnableWebMvc // mvc:annotation-driven
@Configuration
@ComponentScan(basePackages = "com.fpt.fsa.spring.controllers")
@RequiredArgsConstructor
public class SpringWebApplicationConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;
    @Value("${spring.thymeleaf.cache:false}")
    private boolean isCacheTemplate;
    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        // SpringResourceTemplateResolver automatically integrates with Spring's own
        // resource resolution infrastructure, which is highly recommended.
        //SpringResourceTemplateResolver thực hiện thiết lập các thông tin prefix,
        // suffix để chỉ dẫn folder chứa các page view bên trong  thư mục webapp.

        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        // HTML is the default value, added here for the sake of clarity.
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // Template cache is true by default. Set to false if you want
        // templates to be automatically updated when modified.
        templateResolver.setCacheable(isCacheTemplate);

        return templateResolver;
    }

    @Bean
    public FileTemplateResolver fileTemplateResolver() throws IOException {
        final ClassPathResource applicationYaml = new ClassPathResource("application.yaml");
        File sourceRoot = null;
        if (applicationYaml.isFile()) {
            sourceRoot = applicationYaml.getFile().getParentFile();
            while (Objects.requireNonNull(sourceRoot.listFiles((dir, name) -> name.equals("mvnw"))).length != 1) {
                sourceRoot = sourceRoot.getParentFile();
            }
        }

        final FileTemplateResolver fileTemplateResolver = new FileTemplateResolver();
        fileTemplateResolver.setPrefix(sourceRoot.getPath() + "/src/main/resources/templates/");
        fileTemplateResolver.setSuffix(".html");
        fileTemplateResolver.setCacheable(false);
        fileTemplateResolver.setCharacterEncoding("UTF-8");
        fileTemplateResolver.setCheckExistence(true);
        return fileTemplateResolver;
    }

    @Bean
    public ISpringTemplateEngine templateEngine() throws IOException {
        // SpringTemplateEngine automatically applies SpringStandardDialect and
        // enables Spring's own MessageSource message resolution mechanisms.
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        if (activeProfile.equalsIgnoreCase("local")){
            templateEngine.setTemplateResolver(fileTemplateResolver());
        }else{
            templateEngine.setTemplateResolver(templateResolver());
        }
        // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
        // speed up execution in most scenarios, but might be incompatible
        // with specific cases when expressions in one template are reused
        // across different data types, so this flag is "false" by default
        // for safer backwards compatibility.
        templateEngine.setEnableSpringELCompiler(true);
//        templateEngine.addDialect(new LayoutDialect());

        return templateEngine;
    }


    @Bean
    public ViewResolver viewResolver() throws IOException {
        // ViewResolver sẽ thực hiện mapping giữa các file view với view name trả về từ controller,
        // ví dụ trong controller trả về “index” thì nó sẽ hiểu là trả về file index.html
        // trong folder /WEB-INF/templates.
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                        "/webjars/**",
                        "/img/**",
                        "/css/**",
                        "/js/**",
                        "/vendor/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "classpath:/static/vendor/");
    }
}
