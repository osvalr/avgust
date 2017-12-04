package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPlantillaDocumentoArchivo;
import sernanp.app.dao.domain.TPlantillaDocumentoArchivoExample;
import sernanp.app.dao.domain.TPlantillaDocumentoArchivoKey;

public interface TPlantillaDocumentoArchivoMapper {
    int countByExample(TPlantillaDocumentoArchivoExample example);

    int deleteByExample(TPlantillaDocumentoArchivoExample example);

    int deleteByPrimaryKey(TPlantillaDocumentoArchivoKey key);

    int insert(TPlantillaDocumentoArchivo record);

    int insertSelective(TPlantillaDocumentoArchivo record);

    List<TPlantillaDocumentoArchivo> selectByExample(TPlantillaDocumentoArchivoExample example);

    TPlantillaDocumentoArchivo selectByPrimaryKey(TPlantillaDocumentoArchivoKey key);

    int updateByExampleSelective(@Param("record") TPlantillaDocumentoArchivo record, @Param("example") TPlantillaDocumentoArchivoExample example);

    int updateByExample(@Param("record") TPlantillaDocumentoArchivo record, @Param("example") TPlantillaDocumentoArchivoExample example);

    int updateByPrimaryKeySelective(TPlantillaDocumentoArchivo record);

    int updateByPrimaryKey(TPlantillaDocumentoArchivo record);
}