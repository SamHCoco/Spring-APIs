package tvseries.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tvseries.api.repository.TVSeriesRepository;
import tvseries.api.security.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, TVSeriesRepository.class})
public class TVSeriesAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(TVSeriesAPIApplication.class, args);
	}
}
