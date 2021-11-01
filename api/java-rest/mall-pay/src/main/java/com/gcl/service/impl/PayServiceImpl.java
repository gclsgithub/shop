package com.gcl.service.impl;

import com.gcl.dao.PayInfoMapper;
import com.gcl.service.PayService;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private BestPayService bestPayService;

    @Autowired
    private PayInfoMapper payInfoMapper;

    /**
     * 创建支付订单
     * @param orderId 订单ID
     * @param money 订单金额
     * @param bestPayTypeEnum 支付类别
     * @return  PayResponse 支付结果
     */
    public PayResponse create(String orderId, BigDecimal money, BestPayTypeEnum bestPayTypeEnum){

        //查找数据库是否存在相同的订单
        //存在相同的订单则报错
        payInfoMapper.selectByOrderId(orderId);
        //不存在相同的订单号，进行创建订单处理

        PayRequest payRequest = new PayRequest();
        payRequest.setOrderName("6889012-支付宝支付支付测试1");
        payRequest.setOrderId(orderId);
        payRequest.setOrderAmount(money.doubleValue());
        payRequest.setPayTypeEnum(bestPayTypeEnum);

        PayResponse response = bestPayService.pay(payRequest);
        log.info("response:"+response);
        return response;
    }
}
