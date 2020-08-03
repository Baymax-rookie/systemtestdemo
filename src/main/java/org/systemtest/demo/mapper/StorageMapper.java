package org.systemtest.demo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.systemtest.demo.entity.Storage;

import java.util.List;

/**
 * @author 12589
 */
@Mapper
@Component
public interface StorageMapper {
    @Select("SELECT * FROM storage")
    List<Storage> getAllStorage();

    @Insert("INSERT INTO storage(code,name,expire_time,unit,number,price) VALUE(#{code},#{name},#{expireTime},#{unit},#{number},#{price}))")
    boolean isInserted(Storage storage);

    @Update("Update storage SET number=number+#{number} WHERE id=#{id}")
    boolean isAddNumber(Integer number,int id);

    @Update("Update storage SET number=number-#{number} WHERE id=#{id}")
    boolean isSubNumber(Integer number,int id);

    @Delete("Delete FROM storage WHERE id=#{id}")
    boolean isDeleteStorage(int id);

    @Update("Update storage SET number=#{number} WHERE id=#{id}")
    boolean isUpdateNumber(int id);

}
