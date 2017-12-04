package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.MembInfoExt;
import pe.com.acme.domain.mybatis.model.MembInfoExtExample;
import pe.com.acme.domain.mybatis.model.MembInfoExtKey;

public interface MembInfoExtMapper {
    int countByExample(MembInfoExtExample example);

    int deleteByExample(MembInfoExtExample example);

    int deleteByPrimaryKey(MembInfoExtKey key);

    int insert(MembInfoExt record);

    int insertSelective(MembInfoExt record);

    List<MembInfoExt> selectByExampleWithRowbounds(MembInfoExtExample example, RowBounds rowBounds);

    List<MembInfoExt> selectByExample(MembInfoExtExample example);

    MembInfoExt selectByPrimaryKey(MembInfoExtKey key);

    int updateByExampleSelective(@Param("record") MembInfoExt record, @Param("example") MembInfoExtExample example);

    int updateByExample(@Param("record") MembInfoExt record, @Param("example") MembInfoExtExample example);

    int updateByPrimaryKeySelective(MembInfoExt record);

    int updateByPrimaryKey(MembInfoExt record);
}