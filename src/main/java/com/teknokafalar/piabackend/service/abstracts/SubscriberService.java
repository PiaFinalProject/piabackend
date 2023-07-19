package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.SubscriberPostRequest;
import com.teknokafalar.piabackend.dto.SubscriberResponse;
import com.teknokafalar.piabackend.entities.Subscriber;

import java.util.List;

public interface SubscriberService {
    SubscriberResponse postSubscriber(SubscriberPostRequest request);
    List<Subscriber> getSubscriber();
    SubscriberResponse updateSubscriber(SubscriberPostRequest request, Long subscriberId);
    SubscriberResponse deleteSubscriber(Long subscriberId);
}
