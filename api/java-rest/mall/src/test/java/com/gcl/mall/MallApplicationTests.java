package com.gcl.mall;


import com.gcl.mall.dao.CategoryMapper;
import com.gcl.mall.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MallApplicationTests {

    @Resource
    private  CategoryMapper categoryMapper;


    @Test
    public void contextLoads() {

        Category byId = categoryMapper.findById(Integer.valueOf("100003"));

        System.out.println(byId);

    }

}
