package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.MembInfoReferido;
import pe.com.acme.domain.mybatis.model.MembInfoReferidoExample;
import pe.com.acme.domain.mybatis.model.MembInfoReferidoKey;

public interface MembInfoReferidoMapper {
    int countByExample(MembInfoReferidoExample example);

    int deleteByExample(MembInfoReferidoExample example);

    int deleteByPrimaryKey(MembInfoReferidoKey key);

    int insert(MembInfoReferido record);

    int insertSelective(MembInfoReferido record);

    List<MembInfoReferido> selectByExampleWithRowbounds(MembInfoReferidoExample example, RowBounds rowBounds);

    List<MembInfoReferido> selectByExample(MembInfoReferidoExample example);

    MembInfoReferido selectByPrimaryKey(MembInfoReferidoKey key);

    int updateByExampleSelective(@Param("record") MembInfoReferido record, @Param("example") MembInfoReferidoExample example);

    int updateByExample(@Param("record") MembInfoReferido record, @Param("example") MembInfoReferidoExample example);

    int updateByPrimaryKeySelective(MembInfoReferido record);

    int updateByPrimaryKey(MembInfoReferido record);
}