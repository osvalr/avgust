package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPersonaNaturalLegajoArchivo;
import sernanp.app.dao.domain.TPersonaNaturalLegajoArchivoExample;
import sernanp.app.dao.domain.TPersonaNaturalLegajoArchivoKey;

public interface TPersonaNaturalLegajoArchivoMapper {
    int countByExample(TPersonaNaturalLegajoArchivoExample example);

    int deleteByExample(TPersonaNaturalLegajoArchivoExample example);

    int deleteByPrimaryKey(TPersonaNaturalLegajoArchivoKey key);

    int insert(TPersonaNaturalLegajoArchivo record);

    int insertSelective(TPersonaNaturalLegajoArchivo record);

    List<TPersonaNaturalLegajoArchivo> selectByExample(TPersonaNaturalLegajoArchivoExample example);

    TPersonaNaturalLegajoArchivo selectByPrimaryKey(TPersonaNaturalLegajoArchivoKey key);

    int updateByExampleSelective(@Param("record") TPersonaNaturalLegajoArchivo record, @Param("example") TPersonaNaturalLegajoArchivoExample example);

    int updateByExample(@Param("record") TPersonaNaturalLegajoArchivo record, @Param("example") TPersonaNaturalLegajoArchivoExample example);

    int updateByPrimaryKeySelective(TPersonaNaturalLegajoArchivo record);

    int updateByPrimaryKey(TPersonaNaturalLegajoArchivo record);
}