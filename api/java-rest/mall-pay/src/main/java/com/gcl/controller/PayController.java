package com.gcl.controller;

import com.gcl.service.PayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView createWechatPay(){




        return  new ModelAndView("doPay");
    }


}
