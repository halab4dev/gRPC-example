package vn.com.ntqsolution;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * author halab
 */
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceA implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServiceA.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
