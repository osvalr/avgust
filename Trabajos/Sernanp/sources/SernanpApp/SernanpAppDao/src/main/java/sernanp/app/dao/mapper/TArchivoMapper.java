package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TArchivo;
import sernanp.app.dao.domain.TArchivoExample;
import sernanp.app.dao.domain.TArchivoKey;

public interface TArchivoMapper {
    int countByExample(TArchivoExample example);

    int deleteByExample(TArchivoExample example);

    int deleteByPrimaryKey(TArchivoKey key);

    int insert(TArchivo record);

    int insertSelective(TArchivo record);

    List<TArchivo> selectByExample(TArchivoExample example);

    TArchivo selectByPrimaryKey(TArchivoKey key);

    int updateByExampleSelective(@Param("record") TArchivo record, @Param("example") TArchivoExample example);

    int updateByExample(@Param("record") TArchivo record, @Param("example") TArchivoExample example);

    int updateByPrimaryKeySelective(TArchivo record);

    int updateByPrimaryKey(TArchivo record);
}