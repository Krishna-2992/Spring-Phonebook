package com.yash.contactapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String helloWorld() {
        return "hello"; // -> /WEB-INF/view/hello.jsp
    }
}
