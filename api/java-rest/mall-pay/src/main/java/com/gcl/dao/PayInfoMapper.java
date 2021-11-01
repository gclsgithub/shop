package com.gcl.dao;

import com.gcl.entity.PayInfo;
import org.apache.ibatis.annotations.Param;

public interface PayInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayInfo record);

    int insertSelective(PayInfo record);

    PayInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayInfo record);

    int updateByPrimaryKey(PayInfo record);

    /**
     * 通过订单号查找支付情报
     * @param orderId 订单号
     * @return
     */
    PayInfo selectByOrderId(@Param("orderId") String orderId);
}