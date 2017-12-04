package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TRequerimientoPersonalArchivo;
import sernanp.app.dao.domain.TRequerimientoPersonalArchivoExample;
import sernanp.app.dao.domain.TRequerimientoPersonalArchivoKey;

public interface TRequerimientoPersonalArchivoMapper {
    int countByExample(TRequerimientoPersonalArchivoExample example);

    int deleteByExample(TRequerimientoPersonalArchivoExample example);

    int deleteByPrimaryKey(TRequerimientoPersonalArchivoKey key);

    int insert(TRequerimientoPersonalArchivo record);

    int insertSelective(TRequerimientoPersonalArchivo record);

    List<TRequerimientoPersonalArchivo> selectByExample(TRequerimientoPersonalArchivoExample example);

    TRequerimientoPersonalArchivo selectByPrimaryKey(TRequerimientoPersonalArchivoKey key);

    int updateByExampleSelective(@Param("record") TRequerimientoPersonalArchivo record, @Param("example") TRequerimientoPersonalArchivoExample example);

    int updateByExample(@Param("record") TRequerimientoPersonalArchivo record, @Param("example") TRequerimientoPersonalArchivoExample example);

    int updateByPrimaryKeySelective(TRequerimientoPersonalArchivo record);

    int updateByPrimaryKey(TRequerimientoPersonalArchivo record);
}