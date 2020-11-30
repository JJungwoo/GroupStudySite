package com.gss.groupstudysite.controller;

import com.gss.groupstudysite.dto.MailDto;
import com.gss.groupstudysite.service.MailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/api/")
public class MailController {
    private final MailService mailService;

    /*
    @ApiOperation(value = "Test Mail Service", tags = "Mail")
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping("/mail")
    public String dispMail() {
        return "mail";
    }

    @PostMapping("/mail")
    public void execMail(MailDto mailDto) {
        mailService.mailSend(mailDto);
    }

     */
}