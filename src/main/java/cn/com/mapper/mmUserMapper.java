package cn.com.mapper;

import cn.com.entity.mmUser;
import cn.com.entity.mmUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface mmUserMapper {
    int countByExample(mmUserExample example);

    int deleteByExample(mmUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(mmUser record);

    int insertSelective(mmUser record);

    List<mmUser> selectByExample(mmUserExample example);

    mmUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") mmUser record, @Param("example") mmUserExample example);

    int updateByExample(@Param("record") mmUser record, @Param("example") mmUserExample example);

    int updateByPrimaryKeySelective(mmUser record);

    int updateByPrimaryKey(mmUser record);
}