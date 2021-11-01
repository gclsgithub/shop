package com.gcl.service;


import com.gcl.entity.PayInfo;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;

import java.math.BigDecimal;

public interface PayService {

     PayResponse create(String orderId, BigDecimal money, BestPayTypeEnum bestPayTypeEnum);

    PayInfo queryByOrderId(String orderId);
}
