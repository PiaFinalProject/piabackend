package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.MessagePostRequest;
import com.teknokafalar.piabackend.dto.MessageResponse;
import com.teknokafalar.piabackend.entities.Message;

import java.util.List;

public interface MessageService {
    MessageResponse postMessage(MessagePostRequest request);
    List<Message>getMessage();
    MessageResponse deleteMessage(Long messageId);
}
