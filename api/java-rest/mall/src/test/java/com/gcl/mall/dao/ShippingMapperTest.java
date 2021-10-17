package com.gcl.mall.dao;

import com.gcl.mall.MallApplicationTests;
import com.gcl.mall.pojo.Shipping;
import org.junit.Test;

import javax.annotation.Resource;

public class ShippingMapperTest extends MallApplicationTests {

    @Resource
    ShippingMapper shippingMapper;

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Shipping shipping =  shippingMapper.selectByPrimaryKey(1);
        System.out.println(shipping);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}