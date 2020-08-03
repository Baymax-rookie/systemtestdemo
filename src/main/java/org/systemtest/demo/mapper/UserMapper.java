package org.systemtest.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.systemtest.demo.entity.SysUser;

@Component
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id=#{id}")
    SysUser getUserById(Integer id);

    @Select("SELECT * FROM user WHERE name={name}")
    SysUser getUserByUserName(String name);

    @Select("SELECT phone FROM user WHERE name={name}")
    Integer getPhoneByName(String name);

    @Select("SELECT salt FROM user WHERE id=#{id}")
    String getSalt(Integer id);
}
