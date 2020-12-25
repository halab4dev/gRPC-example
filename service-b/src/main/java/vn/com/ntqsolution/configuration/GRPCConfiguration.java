package vn.com.ntqsolution.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * author halab
 */
@Getter
@Configuration
public class GRPCConfiguration {

    @Value("${server.gRPCPort}")
    int port;
}
