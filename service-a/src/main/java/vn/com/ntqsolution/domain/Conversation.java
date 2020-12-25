package vn.com.ntqsolution.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * author halab
 */
@Data
@AllArgsConstructor
public class Conversation {

    private String lastMessage;
    private List<String> participants;
}
