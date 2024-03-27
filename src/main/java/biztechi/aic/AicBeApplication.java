package biztechi.aic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class AicBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AicBeApplication.class, args);
    }
}
