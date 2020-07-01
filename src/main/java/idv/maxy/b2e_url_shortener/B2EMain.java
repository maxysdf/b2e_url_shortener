package idv.maxy.b2e_url_shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * B2E主程式
 * @author Max Chen
 *
 */
@SpringBootApplication
public class B2EMain {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(B2EMain.class);
		app.run(args);
	}
}
