package com.gss.groupstudysite.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/api/")
public class TestController {

    @ApiOperation(value = "Test Service", tags = "Test")
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping("/test")
    public String dispMail() {
        return "index";
    }
}
