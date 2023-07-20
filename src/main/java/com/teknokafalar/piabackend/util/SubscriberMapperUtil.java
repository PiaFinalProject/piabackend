package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.SubscriberPostRequest;
import com.teknokafalar.piabackend.dto.SubscriberResponse;
import com.teknokafalar.piabackend.entities.Subscriber;

public class SubscriberMapperUtil {
    public static Subscriber toSubscriber(SubscriberPostRequest request) {
        Subscriber subscriber = new Subscriber();
        subscriber.setEMail(request.getEMail());

        return subscriber;
    }

    public static SubscriberResponse toSubscriberResponse(Subscriber subscriber) {
        SubscriberResponse response = new SubscriberResponse();

        response.setEMail(subscriber.getEMail());

        return response;
    }
}
