package vn.com.ntqsolution;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import vn.com.ntqsolution.configuration.GRPCConfiguration;
import vn.com.ntqsolution.controller.grpc.UserGrpcController;

import java.io.IOException;

/**
 * author halab
 */
@Component
@AllArgsConstructor
public class GrpcServer {

    private final GRPCConfiguration grpcConfiguration;

    private final UserGrpcController userGrpcController;

    public void start() throws IOException, InterruptedException {
        int port = grpcConfiguration.getPort();
        Server server = ServerBuilder.forPort(port)
                .addService(userGrpcController).build();

        System.out.println("Starting server on port " + port +" ...");
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }
}
