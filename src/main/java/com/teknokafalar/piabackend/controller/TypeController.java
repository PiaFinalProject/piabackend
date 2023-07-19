package com.teknokafalar.piabackend.controller;

import com.teknokafalar.piabackend.core.utilities.results.DataResult;
import com.teknokafalar.piabackend.core.utilities.results.ErrorDataResult;
import com.teknokafalar.piabackend.core.utilities.results.Result;
import com.teknokafalar.piabackend.core.utilities.results.SuccessDataResult;
import com.teknokafalar.piabackend.dto.TypePostRequest;
import com.teknokafalar.piabackend.entities.Type;
import com.teknokafalar.piabackend.service.abstracts.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
@RequiredArgsConstructor
public class TypeController {
    private final TypeService service;
    @PostMapping("/save")
    public Result postType(@RequestBody TypePostRequest request) {
        try {
            return new SuccessDataResult<>(this.service.postType(request),"added type");
        }
        catch (Exception e) {
            e.getMessage();
            return new SuccessDataResult<>("not added, return code");
        }
    }
    @GetMapping("/list")
    public DataResult<List<Type>> getType() {
        try {

            return new SuccessDataResult<>(this.service.getType(), "all of listed type");

        }
        catch (Exception e) {
            return new ErrorDataResult<>("not listed, return code");
        }
    }
    @PutMapping("/update")
    public Result updateType(@RequestBody TypePostRequest request, @RequestParam Long typeId) {
        try {
            return new SuccessDataResult<>(this.service.updateType(request, typeId), "update type");
        }
        catch (Exception e) {
            return new SuccessDataResult<>("not added, rerturn code");
        }
    }
    @DeleteMapping("/delete")
    public Result deleteType(@RequestParam Long typeId) {
        try {
            return new SuccessDataResult<>(this.service.deleteType(typeId), "delete type");
        }
        catch (Exception e) {
            return new SuccessDataResult<>("not delete, return code");
        }
    }
}
