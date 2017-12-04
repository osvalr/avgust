package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Articulo;
import pe.com.acme.domain.mybatis.model.ArticuloExample;
import pe.com.acme.domain.mybatis.model.ArticuloKey;

public interface ArticuloMapper {
    long countByExample(ArticuloExample example);

    int deleteByExample(ArticuloExample example);

    int deleteByPrimaryKey(ArticuloKey key);

    int insert(Articulo record);

    int insertSelective(Articulo record);

    List<Articulo> selectByExampleWithRowbounds(ArticuloExample example, RowBounds rowBounds);

    List<Articulo> selectByExample(ArticuloExample example);

    Articulo selectByPrimaryKey(ArticuloKey key);

    int updateByExampleSelective(@Param("record") Articulo record, @Param("example") ArticuloExample example);

    int updateByExample(@Param("record") Articulo record, @Param("example") ArticuloExample example);

    int updateByPrimaryKeySelective(Articulo record);

    int updateByPrimaryKey(Articulo record);
}