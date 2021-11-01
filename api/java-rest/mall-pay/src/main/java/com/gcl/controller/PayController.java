package com.gcl.controller;

import com.gcl.entity.PayInfo;
import com.gcl.service.PayService;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayService payService;

    @Resource
    private WxPayConfig wxPayConfig;

    @GetMapping("/create")
    public ModelAndView createWechatPay(@RequestParam(value = "orderId",required = true) String orderId,
                                        @RequestParam(value = "money", required = true) String money,
                                        @RequestParam(value = "payType",required = true) BestPayTypeEnum bestPayTypeEnum){
        PayResponse response = payService.create(orderId,new BigDecimal(money),bestPayTypeEnum);
        //支付方式不同，渲染就不同, WXPAY_NATIVE使用codeUrl,  ALIPAY_PC使用body
        Map<String, String> map = new HashMap<>();
        if (bestPayTypeEnum == BestPayTypeEnum.WXPAY_NATIVE) {
            //微信支付
            map.put("codeUrl", response.getCodeUrl());
            map.put("orderId", orderId);
            map.put("returnUrl", wxPayConfig.getReturnUrl());
            return new ModelAndView("doPayWx", map);
        }else if (bestPayTypeEnum == BestPayTypeEnum.ALIPAY_PC) {
            //支付宝支付
            map.put("body", response.getBody());
            return new ModelAndView("doPayAli", map);
        }
        throw new RuntimeException("暂不支持的支付类型");
    }

    @GetMapping("/queryByOrderId")
    @ResponseBody
    public PayInfo queryByOrderId(@RequestParam String orderId){
        return payService.queryByOrderId(orderId);
    }
}
