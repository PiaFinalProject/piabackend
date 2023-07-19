package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.SubscriberPostRequest;
import com.teknokafalar.piabackend.dto.SubscriberResponse;
import com.teknokafalar.piabackend.entities.Subscriber;
import com.teknokafalar.piabackend.excepiton.IdNotFoundException;
import com.teknokafalar.piabackend.repository.SubscriberRepository;
import com.teknokafalar.piabackend.service.abstracts.SubscriberService;
import com.teknokafalar.piabackend.util.SubscriberMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriberServiceImpl implements SubscriberService {
    private final SubscriberRepository repository;

    @Override
    public SubscriberResponse postSubscriber(SubscriberPostRequest request) {
        Subscriber subscriber = SubscriberMapperUtil.toSubscriber(request);
        Subscriber saveSubscriber = repository.save(subscriber);

        return SubscriberMapperUtil.toSubscriberResponse(saveSubscriber);
    }

    @Override
    public List<Subscriber> getSubscriber() {
        return repository.findAll();
    }

    @Override
    public SubscriberResponse updateSubscriber(SubscriberPostRequest request, Long subscriberId) {
        Optional<Subscriber> subscriberDb = this.repository.findById(subscriberId);

        Subscriber subscriber;

        if (subscriberDb.isPresent()) {
            subscriber = subscriberDb.get();
            subscriber.setEMail(request.getEMail());
            repository.save(subscriber);
            return SubscriberMapperUtil.toSubscriberResponse(subscriber);
        }
        throw new RuntimeException("cannot update null value");
    }

    @Override
    public SubscriberResponse deleteSubscriber(Long subscriberId) {
        Optional<Subscriber> subscriberDb = this.repository.findById(subscriberId);

        Subscriber subscriber;

        if (subscriberDb.isPresent()) {
            subscriber = subscriberDb.get();
            this.repository.deleteById(subscriberId);

            return SubscriberMapperUtil.toSubscriberResponse(subscriber);
        }
        throw new IdNotFoundException();
    }
}
