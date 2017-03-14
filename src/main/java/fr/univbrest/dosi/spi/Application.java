package fr.univbrest.dosi.spi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author DOSI
 *
 */
@ComponentScan
@EnableAutoConfiguration
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@Import(RepositoryRestMvcConfiguration.class)
@EnableSwagger2
public class Application extends WebMvcConfigurerAdapter
{
	/**
	 *
	 * @param args
	 *            Init project
	 */
	public static void main(final String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Override
	public final void addResourceHandlers(final ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("swagger-ui.html").addResourceLocations(
				"classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations(
				"classpath:/META-INF/resources/webjars/");

		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/client/")
				.addResourceLocations("classpath:/.tmp/");
	}
}
