package in.strikes.Day9.notificationService.fieldDi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("in.strikes.fieldDi")
public class AppConfig {

    @Bean
    public Address address(){
        return new Address();
    }

    @Bean
    public Employee employee(Address address){
        return new Employee();
    }


}
