package com.mycompany.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ErrorController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/error")
    public String index(HttpServletResponse response, Exception ex) {
        ControllerUtil.errorPage(response, ex);
        return "error";
    }
}
