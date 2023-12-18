package com.devopsclass.exam.controllers;

import com.devopsclass.exam.dtos.DoMathRequest;
import com.devopsclass.exam.exceptions.InvalidOperationException;
import com.devopsclass.exam.services.MathOperator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/math")
@RequiredArgsConstructor
public class MathController {

    private final MathOperator mathService;
    @PostMapping("/doMath")
    public double doMath(@RequestBody DoMathRequest dto) throws InvalidOperationException {
        return mathService.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation());
    }

}
