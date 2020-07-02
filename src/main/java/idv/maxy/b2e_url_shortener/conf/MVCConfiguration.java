package idv.maxy.b2e_url_shortener.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * MVC設定
 * @author Max Chen
 *
 */
@Configuration
@EnableWebMvc
public class MVCConfiguration implements WebMvcConfigurer {
	
	@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
		r.setCharacterEncoding("UTF-8");
		r.setPrefix("pages/");
		r.setSuffix(".html");
		r.setTemplateMode(TemplateMode.HTML);
		r.setOrder(0);

		return r;
	}
		
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**")
				.addResourceLocations("classpath:/pages/js/");
		registry.addResourceHandler("/css/**")
				.addResourceLocations("classpath:/pages/css/");
	}

}
