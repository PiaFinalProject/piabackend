package com.teknokafalar.piabackend.service.abstracts;

import com.teknokafalar.piabackend.dto.request.TypePostRequest;
import com.teknokafalar.piabackend.dto.response.TypeResponse;
import com.teknokafalar.piabackend.entities.Author;
import com.teknokafalar.piabackend.entities.Type;

import java.util.List;

public interface TypeService {

    TypeResponse postType(TypePostRequest request);
    List<Type> getType();

    Type getTypeById(Long typeId);

    TypeResponse updateType(TypePostRequest request, Long typeId);
    TypeResponse deleteType(Long typeId);
     Type getById(Long id) ;

    }
