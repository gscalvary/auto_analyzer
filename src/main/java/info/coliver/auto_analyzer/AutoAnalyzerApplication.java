package info.coliver.auto_analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AutoAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoAnalyzerApplication.class, args);
	}

}
