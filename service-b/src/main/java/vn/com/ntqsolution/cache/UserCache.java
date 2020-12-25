package vn.com.ntqsolution.cache;

import vn.com.ntqsolution.domain.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author halab
 */
public class UserCache {

    public static final Map<String, User> USER_CACHE = new ConcurrentHashMap<>();

    static {
        USER_CACHE.put("a", new User("a","halab", 20));
        USER_CACHE.put("b", new User("b", "huydx", 30));
    }

    public static User getUser(String userId) {
        return USER_CACHE.get(userId);
    }
}
