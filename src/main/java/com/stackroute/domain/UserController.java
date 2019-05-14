package com.stackroute.domain;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
    private User user = (User)context.getBean("user");
    @RequestMapping("/")
    public String Index(){
        return "index";
    }
    @RequestMapping("start")
    public ModelAndView display(HttpServletRequest request, HttpServletResponse response){
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Display");
        if(user.checkPassword())
            mv.addObject("Name",user.getName());
        else
            mv.addObject("Name","Unknown User");
        return mv;
    }
}
