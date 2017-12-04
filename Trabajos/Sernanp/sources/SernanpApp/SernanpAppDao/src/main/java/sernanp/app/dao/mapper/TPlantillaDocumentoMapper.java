package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPlantillaDocumento;
import sernanp.app.dao.domain.TPlantillaDocumentoExample;
import sernanp.app.dao.domain.TPlantillaDocumentoKey;

public interface TPlantillaDocumentoMapper {
    int countByExample(TPlantillaDocumentoExample example);

    int deleteByExample(TPlantillaDocumentoExample example);

    int deleteByPrimaryKey(TPlantillaDocumentoKey key);

    int insert(TPlantillaDocumento record);

    int insertSelective(TPlantillaDocumento record);

    List<TPlantillaDocumento> selectByExample(TPlantillaDocumentoExample example);

    TPlantillaDocumento selectByPrimaryKey(TPlantillaDocumentoKey key);

    int updateByExampleSelective(@Param("record") TPlantillaDocumento record, @Param("example") TPlantillaDocumentoExample example);

    int updateByExample(@Param("record") TPlantillaDocumento record, @Param("example") TPlantillaDocumentoExample example);

    int updateByPrimaryKeySelective(TPlantillaDocumento record);

    int updateByPrimaryKey(TPlantillaDocumento record);
}