package vn.com.ntqsolution;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author halab
 */
@AllArgsConstructor
@SpringBootApplication
public class ServiceB implements CommandLineRunner {

    private final GrpcServer grpcServer;

    public static void main(String[] args) {
        SpringApplication.run(ServiceB.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        grpcServer.start();
    }
}
