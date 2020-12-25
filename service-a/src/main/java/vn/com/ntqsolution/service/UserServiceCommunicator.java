package vn.com.ntqsolution.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistration;
import org.springframework.stereotype.Component;
import vn.com.ntqsolution.controller.*;
import vn.com.ntqsolution.worker.ServiceDiscoverer;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

/**
 * author halab
 */
@Component
@AllArgsConstructor
public class UserServiceCommunicator {

//    private final DiscoveryClient client;

    public GetUserResponse callServiceB(String userId) {
//        Optional<ServiceInstance> serviceInstanceOptional = client.getInstances("Service-B").stream().findFirst();
////                .map(s -> s.resolve("/greeting")).get();
//
//        if (!serviceInstanceOptional.isPresent()) {
//            System.out.println("No service instance available");
//            return null;
//        }
//
//        ServiceInstance serviceInstance = serviceInstanceOptional.get();
//        Map<String, String> metadata = serviceInstance.getMetadata();
//        int port = Integer.parseInt(metadata.get("gRPCPort"));
//        ManagedChannel channel = ManagedChannelBuilder.forAddress(serviceInstance.getHost(), port)
//                .usePlaintext()
//                .build();

        ManagedChannel channel = ServiceDiscoverer.getServiceBChannel();
        UserServiceGrpc.UserServiceBlockingStub stub
                = UserServiceGrpc.newBlockingStub(channel);

        GetUserResponse getUserResponse = stub.getUser(GetUserRequest.newBuilder()
                .setUserId(userId)
                .build());

        System.out.println("Response received from server:\n" + getUserResponse);

//        channel.shutdown();
//        return GetUserResponse.getDefaultInstance();
        return getUserResponse;
    }
}
