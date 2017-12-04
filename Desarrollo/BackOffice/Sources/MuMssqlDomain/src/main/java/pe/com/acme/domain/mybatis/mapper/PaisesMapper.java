package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Paises;
import pe.com.acme.domain.mybatis.model.PaisesExample;
import pe.com.acme.domain.mybatis.model.PaisesKey;

public interface PaisesMapper {
    int countByExample(PaisesExample example);

    int deleteByExample(PaisesExample example);

    int deleteByPrimaryKey(PaisesKey key);

    int insert(Paises record);

    int insertSelective(Paises record);

    List<Paises> selectByExampleWithRowbounds(PaisesExample example, RowBounds rowBounds);

    List<Paises> selectByExample(PaisesExample example);

    Paises selectByPrimaryKey(PaisesKey key);

    int updateByExampleSelective(@Param("record") Paises record, @Param("example") PaisesExample example);

    int updateByExample(@Param("record") Paises record, @Param("example") PaisesExample example);

    int updateByPrimaryKeySelective(Paises record);

    int updateByPrimaryKey(Paises record);
}