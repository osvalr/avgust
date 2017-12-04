package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Catalogo;
import pe.com.acme.domain.mybatis.model.CatalogoExample;
import pe.com.acme.domain.mybatis.model.CatalogoKey;

public interface CatalogoMapper {
    int countByExample(CatalogoExample example);

    int deleteByExample(CatalogoExample example);

    int deleteByPrimaryKey(CatalogoKey key);

    int insert(Catalogo record);

    int insertSelective(Catalogo record);

    List<Catalogo> selectByExampleWithRowbounds(CatalogoExample example, RowBounds rowBounds);

    List<Catalogo> selectByExample(CatalogoExample example);

    Catalogo selectByPrimaryKey(CatalogoKey key);

    int updateByExampleSelective(@Param("record") Catalogo record, @Param("example") CatalogoExample example);

    int updateByExample(@Param("record") Catalogo record, @Param("example") CatalogoExample example);

    int updateByPrimaryKeySelective(Catalogo record);

    int updateByPrimaryKey(Catalogo record);
}