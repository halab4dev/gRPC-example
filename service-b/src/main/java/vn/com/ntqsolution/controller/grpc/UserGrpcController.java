package vn.com.ntqsolution.controller.grpc;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;
import vn.com.ntqsolution.cache.UserCache;
import vn.com.ntqsolution.controller.GetUserRequest;
import vn.com.ntqsolution.controller.GetUserResponse;
import vn.com.ntqsolution.controller.UserServiceGrpc;
import vn.com.ntqsolution.domain.User;

/**
 * author halab
 */
@Component
public class UserGrpcController extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUser(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);

        String userId = request.getUserId();
        User user = UserCache.getUser(userId);

        GetUserResponse response = GetUserResponse.newBuilder()
                .setUserId(user.getUserId())
                .setUsername(user.getUsername())
                .setAge(user.getAge())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
