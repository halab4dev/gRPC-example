package vn.com.ntqsolution.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author halab
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userId;
    private String username;
    private int age;
}
