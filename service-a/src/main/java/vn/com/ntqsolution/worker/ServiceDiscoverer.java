package vn.com.ntqsolution.worker;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * References: https://sultanov.dev/blog/grpc-client-side-load-balancing/
 *
 * author halab
 */
@Component
@AllArgsConstructor
public class ServiceDiscoverer {

    private static ManagedChannel serviceBChannel;

    private final DiscoveryClient client;

    @Scheduled(cron = " 0/30 * * * * *")
    public void scan() {
        List<ServiceInstance> serviceInstances = client.getInstances("Service-B");
        if (serviceInstances.isEmpty()) {
            return;
        }
        List<InetSocketAddress> inetSocketAddresses = serviceInstances.stream().map(serviceInstance -> {
            String host = serviceInstance.getHost();
            Map<String, String> metadata = serviceInstance.getMetadata();
            int port = Integer.parseInt(metadata.get("gRPCPort"));
            return new InetSocketAddress(host, port);
        }).collect(Collectors.toList());

        NameResolver.Factory nameResolverFactory = new MultiAddressNameResolverFactory(inetSocketAddresses);
        serviceBChannel = ManagedChannelBuilder.forTarget("service")
                .nameResolverFactory(nameResolverFactory)
                .defaultLoadBalancingPolicy("round_robin")
                .usePlaintext()
                .build();
    }

    public static ManagedChannel getServiceBChannel() {
        return serviceBChannel;
    }
}
