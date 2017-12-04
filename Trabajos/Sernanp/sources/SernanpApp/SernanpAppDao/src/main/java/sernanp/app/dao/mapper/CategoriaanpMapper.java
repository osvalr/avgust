package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Categoriaanp;
import sernanp.app.dao.domain.CategoriaanpExample;
import sernanp.app.dao.domain.CategoriaanpKey;

public interface CategoriaanpMapper {
    int countByExample(CategoriaanpExample example);

    int deleteByExample(CategoriaanpExample example);

    int deleteByPrimaryKey(CategoriaanpKey key);

    int insert(Categoriaanp record);

    int insertSelective(Categoriaanp record);

    List<Categoriaanp> selectByExample(CategoriaanpExample example);

    Categoriaanp selectByPrimaryKey(CategoriaanpKey key);

    int updateByExampleSelective(@Param("record") Categoriaanp record, @Param("example") CategoriaanpExample example);

    int updateByExample(@Param("record") Categoriaanp record, @Param("example") CategoriaanpExample example);

    int updateByPrimaryKeySelective(Categoriaanp record);

    int updateByPrimaryKey(Categoriaanp record);
}