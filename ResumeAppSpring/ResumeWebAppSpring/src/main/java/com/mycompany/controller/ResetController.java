package com.mycompany.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ResetController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/reset")
    public String index() {
        return "reset";
    }
}
