package test.app.config;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Order(1)
@Configuration
public class BootInitialization implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.println("##########################addViewControllers################################");
		registry.addViewController("/").setViewName("forward:/index.jsp");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	@Bean
    public SessionLocaleResolver localeResolver() {
		System.out.println("##########################SessionLocaleResolver################################");
        return new SessionLocaleResolver();
    }

	@Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        System.out.println("##########################LocaleChangeInterceptor################################");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	System.out.println("##########################addInterceptors################################");
        registry.addInterceptor(localeChangeInterceptor());
    }

}
