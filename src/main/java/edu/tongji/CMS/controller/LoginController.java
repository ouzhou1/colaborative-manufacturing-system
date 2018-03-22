package edu.tongji.CMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ouzhou on 2017/5/20.
 */

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping(value = "")
    public ModelAndView loginPage() {
        // return new ModelAndView("signin");
        return new ModelAndView("index");
    }

    @GetMapping(value = "login")
    public ModelAndView userLogin() {
        return new ModelAndView("login");
    }

    @GetMapping(value = "register")
    public ModelAndView userRegister() {
        return new ModelAndView("register");
    }
}
