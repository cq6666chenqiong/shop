package com.zhsj.m.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BaseController {
    Logger logger = LoggerFactory.getLogger(BaseController.class);


    @RequestMapping(value = "/accWeixin", method = RequestMethod.GET)
    @ResponseBody
    public void accWeixin(HttpServletRequest request, HttpServletResponse response) {
    }

}
