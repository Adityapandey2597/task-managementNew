import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.aditya.*")
@EntityScan(basePackages = "com.aditya.*")
@EnableJpaRepositories(basePackages = "com.aditya.*")
@EnableAutoConfiguration
public class TaskMicroserviceApplication {
    public static void main(String[] args){

        SpringApplication.run(TaskMicroserviceApplication.class, args);


    }

}
