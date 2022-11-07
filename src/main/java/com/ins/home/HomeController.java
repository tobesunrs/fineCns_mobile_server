package com.ins.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(HttpServletRequest req){
        return "index";
    }
}
