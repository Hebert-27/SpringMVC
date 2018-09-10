package br.com.estoque.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.estoque.controllers.IndexController;
import br.com.estoque.daos.ProdutoDAO;
import br.com.estoque.infra.FileSaver;

@EnableWebMvc
@ComponentScan(basePackageClasses={IndexController.class, ProdutoDAO.class, FileSaver.class})
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	//Método que vai entregar o message source
	@Bean
	public MessageSource messageSource() {
		
		ReloadableResourceBundleMessageSource messageSource 
			= new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}
	
	/*@Bean
	public FormattingConversionService mvcConvesionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar =  new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
	}*/
	@Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
}
