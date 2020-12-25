package vn.com.ntqsolution.controller.http.response;

import lombok.Data;
import vn.com.ntqsolution.domain.ConversationParticipant;

import java.util.List;

/**
 * author halab
 */
@Data
public class ConversationResponse {

    private String lastMessage;
    private List<ConversationParticipant> participants;
}
