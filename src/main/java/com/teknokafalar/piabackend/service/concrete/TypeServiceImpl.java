package com.teknokafalar.piabackend.service.concrete;

import com.teknokafalar.piabackend.dto.request.TypePostRequest;
import com.teknokafalar.piabackend.dto.response.TypeResponse;
import com.teknokafalar.piabackend.entities.Type;
import com.teknokafalar.piabackend.repository.TypeRepository;
import com.teknokafalar.piabackend.service.abstracts.TypeService;
import com.teknokafalar.piabackend.util.TypeMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {
    private final TypeRepository repository;
    @Override
    public TypeResponse postType(TypePostRequest request) {
        Type type = TypeMapperUtil.toType(request);
        Type saveType = repository.save(type);

        return TypeMapperUtil.toTypeResponse(saveType);
    }

    @Override
    public List<Type> getType() {
        return repository.findAll();
    }

    @Override
    public Type getById(Long id) {
        Optional<Type> byId = repository.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            return null;
    }

    @Override
    public TypeResponse updateType(TypePostRequest request, Long typeId) {
        Optional<Type> typeDb = this.repository.findById(typeId);
        Type type= null;

        if (typeDb.isPresent()) {
            type = typeDb.get();
            type.setName(request.getName());
        }
        repository.save(type);

        return TypeMapperUtil.toTypeResponse(type);
    }

    @Override
    public TypeResponse deleteType(Long typeId) {
        Type typeDb = this.repository.findById(typeId).orElse(null);

        this.repository.deleteById(typeId);

        return TypeMapperUtil.toTypeResponse(typeDb);
    }

}
