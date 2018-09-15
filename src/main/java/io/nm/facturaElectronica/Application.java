package io.nm.facturaElectronica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.nm.facturaElectronica.configuration.ConfigurationReader;

@EnableScheduling
@EntityScan(basePackages = { "io.nm.facturaElectronica" })
@ComponentScan("io.nm.facturaElectronica")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public Application() {
		//SpringApplication.run(Application.class);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		ConfigurationReader cr = new ConfigurationReader();
		try {
			if (!cr.loadConfiguration())
				throw new Exception("Error al cargar la configuracion");
			return application.sources(applicationClass);
		} catch (Exception e) {
			e.printStackTrace();
			return application.sources(applicationClass);
		}
	}

	public static void main(String[] args) throws Exception {
		ConfigurationReader cr = new ConfigurationReader();
		if (cr.loadConfiguration())
			SpringApplication.run(applicationClass, args);
		else
			throw new Exception("Error al cargar la configuracion");
	}

	private static Class<Application> applicationClass = Application.class;
}
