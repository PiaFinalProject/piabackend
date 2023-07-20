package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.dto.MessagePostRequest;
import com.teknokafalar.piabackend.dto.MessageResponse;
import com.teknokafalar.piabackend.entities.Message;
import com.teknokafalar.piabackend.repository.MessageRepository;
import com.teknokafalar.piabackend.service.abstracts.MessageService;
import com.teknokafalar.piabackend.util.MessageMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository repository;
    @Override
    public MessageResponse postMessage(MessagePostRequest request) {
        Message message = MessageMapperUtil.toMessage(request);
        Message saveMessage = repository.save(message);

        return MessageMapperUtil.toMessageResponse(saveMessage);
    }
    @Override
    public List<Message> getMessage() {
        return repository.findAll();
    }
    @Override
    public MessageResponse deleteMessage(Long messageId) {
        Optional<Message> messageDb = this.repository.findById(messageId);

        Message message;

        if(messageDb.isPresent()) {
            message = messageDb.get();
            this.repository.deleteById(messageId);

            return MessageMapperUtil.toMessageResponse(message);
        }
        throw new RuntimeException("cannot delete null value");
    }
}
