package main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 30.04.2017.
 */
@Controller
public class PageController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage(HttpServletRequest req) {
        req.getSession().setAttribute("loginError", "");
        return "login";

    }

}
