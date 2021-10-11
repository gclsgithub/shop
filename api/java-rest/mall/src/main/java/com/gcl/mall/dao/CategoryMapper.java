package com.gcl.mall.dao;

import com.gcl.mall.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper {

    /**
     * 查找类目的对象
     * @param id
     * @return
     */
    @Select("select * from mall_category where id = #{id}")
    Category findById(@Param("id") Integer id);


}
