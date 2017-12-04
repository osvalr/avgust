package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TConvAreaOrgArchivo;
import sernanp.app.dao.domain.TConvAreaOrgArchivoExample;
import sernanp.app.dao.domain.TConvAreaOrgArchivoKey;

public interface TConvAreaOrgArchivoMapper {
    int countByExample(TConvAreaOrgArchivoExample example);

    int deleteByExample(TConvAreaOrgArchivoExample example);

    int deleteByPrimaryKey(TConvAreaOrgArchivoKey key);

    int insert(TConvAreaOrgArchivo record);

    int insertSelective(TConvAreaOrgArchivo record);

    List<TConvAreaOrgArchivo> selectByExample(TConvAreaOrgArchivoExample example);

    TConvAreaOrgArchivo selectByPrimaryKey(TConvAreaOrgArchivoKey key);

    int updateByExampleSelective(@Param("record") TConvAreaOrgArchivo record, @Param("example") TConvAreaOrgArchivoExample example);

    int updateByExample(@Param("record") TConvAreaOrgArchivo record, @Param("example") TConvAreaOrgArchivoExample example);

    int updateByPrimaryKeySelective(TConvAreaOrgArchivo record);

    int updateByPrimaryKey(TConvAreaOrgArchivo record);
}