package com.yfny.servicetips.mapper;

import com.yfny.servicecommon.pojo.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * 菜单mapper
 * Created by zileShi on 2019/2/26.
 **/
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {

    @Select("select * from `order` where permission = #{permission}")
    @Results({
            @Result(id=true, column="id", property="id"),
            @Result(property = "permission", column = "permission"),
            @Result(property = "function", column = "function"),
    })
    public OrderEntity getOrderByPermission(String permission);

}
