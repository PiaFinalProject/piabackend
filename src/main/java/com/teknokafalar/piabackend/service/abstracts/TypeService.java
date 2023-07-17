package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.TypePostRequest;
import com.teknokafalar.piabackend.dto.TypeResponse;
import com.teknokafalar.piabackend.entities.Type;

import java.util.List;

public interface TypeService {

    TypeResponse postType(TypePostRequest request);
    List<Type> getType();
    TypeResponse updateType(TypePostRequest request, Long typeId);
    TypeResponse deleteType(Long typeId);
}
