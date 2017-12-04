package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TPostulantePersonalArchivo;
import sernanp.app.dao.domain.TPostulantePersonalArchivoExample;
import sernanp.app.dao.domain.TPostulantePersonalArchivoKey;

public interface TPostulantePersonalArchivoMapper {
    int countByExample(TPostulantePersonalArchivoExample example);

    int deleteByExample(TPostulantePersonalArchivoExample example);

    int deleteByPrimaryKey(TPostulantePersonalArchivoKey key);

    int insert(TPostulantePersonalArchivo record);

    int insertSelective(TPostulantePersonalArchivo record);

    List<TPostulantePersonalArchivo> selectByExampleWithRowbounds(TPostulantePersonalArchivoExample example, RowBounds rowBounds);

    List<TPostulantePersonalArchivo> selectByExample(TPostulantePersonalArchivoExample example);

    TPostulantePersonalArchivo selectByPrimaryKey(TPostulantePersonalArchivoKey key);

    int updateByExampleSelective(@Param("record") TPostulantePersonalArchivo record, @Param("example") TPostulantePersonalArchivoExample example);

    int updateByExample(@Param("record") TPostulantePersonalArchivo record, @Param("example") TPostulantePersonalArchivoExample example);

    int updateByPrimaryKeySelective(TPostulantePersonalArchivo record);

    int updateByPrimaryKey(TPostulantePersonalArchivo record);
}