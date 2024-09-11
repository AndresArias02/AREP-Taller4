package edu.eci.arep.virtualization.service;

import edu.eci.arep.virtualization.model.Message;
import edu.eci.arep.virtualization.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Message service
 * @author Andrés Arias
 */
@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getlastTenMessage() {
        List<Message> messageArrayList = new ArrayList<>();
        List<Message> messages = messageRepository.findAll();
        Collections.reverse(messages);
        for (int i = 0; i <  messages.size() && i < 10; i++) {
            messageArrayList.add(messages.get(i));
        }
        return messageArrayList;
    }
}
