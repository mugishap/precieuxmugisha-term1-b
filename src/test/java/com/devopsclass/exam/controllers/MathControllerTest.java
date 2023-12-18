package com.devopsclass.exam.controllers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.devopsclass.exam.dtos.DoMathRequest;
import com.devopsclass.exam.payload.ApiResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void doMathOperation_Success() {
        DoMathRequest dto = new DoMathRequest(4, 9, "+");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/math/doMath", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCode().value());
    }
}