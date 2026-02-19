package startup2.data;

// You need these new imports for the lab
import java.util.Arrays; // [cite: 77]
import org.springframework.boot.CommandLineRunner; // [cite: 78]
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext; // [cite: 81]
import org.springframework.context.annotation.Bean; // [cite: 82]

@SpringBootApplication
public class DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }

    // --- ACTIVITY 2, STEP 3: NEW CODE BLOCK ---
    @Bean // [cite: 88]
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) { // [cite: 89]
        return args -> { // [cite: 90]
            System.out.println("Let's inspect the beans provided by Spring Boot:"); // [cite: 91]
            String[] beanNames = ctx.getBeanDefinitionNames(); // [cite: 92]
            Arrays.sort(beanNames); // [cite: 93]
            for (String beanName : beanNames) { // [cite: 94]
                System.out.println(beanName); // [cite: 95]
            } // [cite: 96]
        }; // [cite: 97]
    } // [cite: 98]

}