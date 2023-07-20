package com.teknokafalar.piabackend.util;

import com.teknokafalar.piabackend.dto.request.TypePostRequest;
import com.teknokafalar.piabackend.dto.response.TypeResponse;
import com.teknokafalar.piabackend.entities.Type;

public class TypeMapperUtil {
    public static Type toType(TypePostRequest request) {
        Type type = new Type();
        type.setName(request.getName());
        return type;
    }
    public static TypeResponse toTypeResponse(Type type) {
        TypeResponse response = new TypeResponse();

        response.setName(type.getName());

        return response;
    }
}
