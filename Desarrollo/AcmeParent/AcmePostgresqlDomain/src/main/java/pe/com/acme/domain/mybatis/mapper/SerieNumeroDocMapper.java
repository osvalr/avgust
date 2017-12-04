package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.SerieNumeroDoc;
import pe.com.acme.domain.mybatis.model.SerieNumeroDocExample;
import pe.com.acme.domain.mybatis.model.SerieNumeroDocKey;

public interface SerieNumeroDocMapper {
    long countByExample(SerieNumeroDocExample example);

    int deleteByExample(SerieNumeroDocExample example);

    int deleteByPrimaryKey(SerieNumeroDocKey key);

    int insert(SerieNumeroDoc record);

    int insertSelective(SerieNumeroDoc record);

    List<SerieNumeroDoc> selectByExampleWithRowbounds(SerieNumeroDocExample example, RowBounds rowBounds);

    List<SerieNumeroDoc> selectByExample(SerieNumeroDocExample example);

    SerieNumeroDoc selectByPrimaryKey(SerieNumeroDocKey key);

    int updateByExampleSelective(@Param("record") SerieNumeroDoc record, @Param("example") SerieNumeroDocExample example);

    int updateByExample(@Param("record") SerieNumeroDoc record, @Param("example") SerieNumeroDocExample example);

    int updateByPrimaryKeySelective(SerieNumeroDoc record);

    int updateByPrimaryKey(SerieNumeroDoc record);
}