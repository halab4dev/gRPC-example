package vn.com.ntqsolution.controller.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author halab
 */
@RestController
@RequestMapping("chat/v1/pings")
public class PingController {

    @GetMapping
    public String ping() {
        return "pong";
    }
}
