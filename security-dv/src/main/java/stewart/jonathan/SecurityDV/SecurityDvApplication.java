package stewart.jonathan.SecurityDV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import stewart.jonathan.SecurityDV.config.RsaKeyProperties;

import javax.crypto.SecretKey;

@EnableConfigurationProperties(SecretKey.class)
@SpringBootApplication
public class SecurityDvApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDvApplication.class, args);
	}

}
