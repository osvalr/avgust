package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Aplicacion;
import pe.com.acme.domain.mybatis.model.AplicacionExample;
import pe.com.acme.domain.mybatis.model.AplicacionKey;

public interface AplicacionMapper {
    int countByExample(AplicacionExample example);

    int deleteByExample(AplicacionExample example);

    int deleteByPrimaryKey(AplicacionKey key);

    int insert(Aplicacion record);

    int insertSelective(Aplicacion record);

    List<Aplicacion> selectByExampleWithRowbounds(AplicacionExample example, RowBounds rowBounds);

    List<Aplicacion> selectByExample(AplicacionExample example);

    Aplicacion selectByPrimaryKey(AplicacionKey key);

    int updateByExampleSelective(@Param("record") Aplicacion record, @Param("example") AplicacionExample example);

    int updateByExample(@Param("record") Aplicacion record, @Param("example") AplicacionExample example);

    int updateByPrimaryKeySelective(Aplicacion record);

    int updateByPrimaryKey(Aplicacion record);
}