package com.mycompany.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView index(
            @RequestParam(value = "value", required = false) Object value) {

        // write code here
        List<?> list = new ArrayList<>();
        ModelAndView mv = new ModelAndView("viewName");
        mv.addObject("list", list);
        return mv;
    }
}
