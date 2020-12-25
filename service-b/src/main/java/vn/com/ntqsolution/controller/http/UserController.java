package vn.com.ntqsolution.controller.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.ntqsolution.cache.UserCache;
import vn.com.ntqsolution.controller.GetUserResponse;
import vn.com.ntqsolution.domain.User;

/**
 * author halab
 */
@RestController
@RequestMapping("ums/v1/users")
public class UserController {

    @GetMapping("/{userId}")
    public GetUserResponse getUser(
            @PathVariable("userId") String userId
    ) {
        User user = UserCache.getUser(userId);
        return GetUserResponse.newBuilder()
                .setUserId(user.getUserId())
                .setUsername(user.getUsername())
                .setAge(user.getAge())
                .build();
    }
}
