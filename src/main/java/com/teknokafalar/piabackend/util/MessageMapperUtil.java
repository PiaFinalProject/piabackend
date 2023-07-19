package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.MessagePostRequest;
import com.teknokafalar.piabackend.dto.MessageResponse;
import com.teknokafalar.piabackend.entities.Message;

public class MessageMapperUtil {
    public static Message toMessage(MessagePostRequest request) {
        Message message = new Message();
        message.setFirstName(request.getFirstName());
        message.setLastName(request.getLastName());
        message.setCurrentBook(request.getCurrentBook());
        message.setEMail(request.getEMail());
        message.setMessageSubject(request.getMessageSubject());

        return message;
    }
    public static MessageResponse toMessageResponse(Message message){
        MessageResponse response = new MessageResponse();

        response.setFirstName(message.getFirstName());
        response.setLastName(message.getLastName());
        response.setCurrentBook(message.getCurrentBook());
        response.setEMail(message.getEMail());
        response.setMessageSubject(message.getMessageSubject());

        return response;
    }
}
