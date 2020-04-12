package com.mycompany.controller;

import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceInter userService;

//    @RequestMapping(method = RequestMethod.GET, value = "/users1")
//    public String index(HttpServletRequest request){
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        String ageStr = request.getParameter("age");
//        Integer age = null;
//        if (ageStr != null) {
//            age = Integer.parseInt(ageStr);
//        }
//        List<User> users = userService.getAll(name, surname, age);
//        request.setAttribute("users", users);
//        return "users";
//    }


    //Method with Spring RequestParam
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "age", required = false) Integer age) {

        List<User> users = userService.getAll(name, surname, age);
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", users);
        return mv;
    }

    //Method with Spring tags - ModelAttribute
    @RequestMapping(method = RequestMethod.GET, value = "/usersm")
    public ModelAndView index(@Valid @ModelAttribute("user") User u, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("users");
        if (bindingResult.hasErrors()) {
            return mv;
        }
        List<User> users = userService.getAll(u.getName(), u.getSurname(), u.getAge());
        mv.addObject("users", users);
        return mv;
    }

    //Spring tags sehife her defe yuklenende imputlara deyer yuklemek uchun bu bosh obyekted istifade edecek
    //Eger bele bir obyekt olmasa idi imputlara yuklenecek deyer tapilmadigi uchun biz error alacaqdiq
    @ModelAttribute("user")
    public User getEmptyUserForm() {
        return new User();
    }
}
