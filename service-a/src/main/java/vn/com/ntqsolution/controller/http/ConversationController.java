package vn.com.ntqsolution.controller.http;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.ntqsolution.service.UserServiceCommunicator;
import vn.com.ntqsolution.controller.GetUserResponse;
import vn.com.ntqsolution.controller.http.response.ConversationResponse;
import vn.com.ntqsolution.domain.Conversation;
import vn.com.ntqsolution.domain.ConversationParticipant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author halab
 */
@RestController
@AllArgsConstructor
@RequestMapping("chat/v1/conversations")
public class ConversationController {

    private final UserServiceCommunicator userServiceCommunicator;

    private final List<Conversation> conversations = Arrays.asList(
            new Conversation("Hello", Arrays.asList("a", "b"))
    );

    @GetMapping
    public List<ConversationResponse> listAll() {
        return conversations.stream().map(conversation -> {
            List<String> userIds = conversation.getParticipants();
            List<ConversationParticipant> participants = userIds.stream().map(userId -> {
                GetUserResponse user = userServiceCommunicator.callServiceB(userId);
                ConversationParticipant participant = new ConversationParticipant();
                participant.setUserId(user.getUserId());
                participant.setUsername(user.getUsername());
                return participant;
            }).collect(Collectors.toList());
            ConversationResponse conversationResponse = new ConversationResponse();
            conversationResponse.setLastMessage(conversation.getLastMessage());
            conversationResponse.setParticipants(participants);
            return conversationResponse;
        }).collect(Collectors.toList());
    }
}
