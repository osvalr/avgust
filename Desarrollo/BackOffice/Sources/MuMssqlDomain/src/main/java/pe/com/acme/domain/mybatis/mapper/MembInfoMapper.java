package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.MembInfo;
import pe.com.acme.domain.mybatis.model.MembInfoExample;
import pe.com.acme.domain.mybatis.model.MembInfoKey;

public interface MembInfoMapper {
    int countByExample(MembInfoExample example);

    int deleteByExample(MembInfoExample example);

    int deleteByPrimaryKey(MembInfoKey key);

    int insert(MembInfo record);

    int insertSelective(MembInfo record);

    List<MembInfo> selectByExampleWithRowbounds(MembInfoExample example, RowBounds rowBounds);

    List<MembInfo> selectByExample(MembInfoExample example);

    MembInfo selectByPrimaryKey(MembInfoKey key);

    int updateByExampleSelective(@Param("record") MembInfo record, @Param("example") MembInfoExample example);

    int updateByExample(@Param("record") MembInfo record, @Param("example") MembInfoExample example);

    int updateByPrimaryKeySelective(MembInfo record);

    int updateByPrimaryKey(MembInfo record);
}