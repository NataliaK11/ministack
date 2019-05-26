package pl.nataliakozub.ministack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.SessionTrackingMode;
import java.util.Collections;

@SpringBootApplication
public class MinistackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinistackApplication.class, args);

//		@Bean
//		public ServletContextInitializer servletContextInitializer() {
//			return servletContext -> servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
//		}

	}

}


//@RequestBody zwraca tekst zamiast templatki
