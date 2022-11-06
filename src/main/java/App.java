import com.sun.faces.config.FacesInitializer;
import com.sun.faces.context.ExceptionHandlerFactoryImpl;
import com.sun.faces.context.FacesContextFactoryImpl;
import org.apache.el.ExpressionFactoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.el.ExpressionFactory;
import javax.faces.context.ExceptionHandlerFactory;
import javax.faces.context.FacesContextFactory;
import javax.faces.webapp.FacesServlet;

@EnableAutoConfiguration
@ComponentScan({"com.xgodness.spring-jsf-baeldung"})
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(
                new FacesServlet(),
                "*.xhtml"
        );
    }



//    @Bean
//    public ExpressionFactory expressionFactoryRegistrationBean() {
//        return new ExpressionFactoryImpl();
//    }
//
//    @Bean
//    public FacesContextFactory facesContextFactoryRegistrationBean() {
//        return new FacesContextFactoryImpl();
//    }
//
//    @Bean
//    public ExceptionHandlerFactory exceptionHandlerFactoryRegistrationBean() {
//        return new ExceptionHandlerFactoryImpl();
//    }

}
