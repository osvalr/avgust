package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TFuenteFinanciamiento;
import sernanp.app.dao.domain.TFuenteFinanciamientoExample;
import sernanp.app.dao.domain.TFuenteFinanciamientoKey;

public interface TFuenteFinanciamientoMapper {
    int countByExample(TFuenteFinanciamientoExample example);

    int deleteByExample(TFuenteFinanciamientoExample example);

    int deleteByPrimaryKey(TFuenteFinanciamientoKey key);

    int insert(TFuenteFinanciamiento record);

    int insertSelective(TFuenteFinanciamiento record);

    List<TFuenteFinanciamiento> selectByExampleWithRowbounds(TFuenteFinanciamientoExample example, RowBounds rowBounds);

    List<TFuenteFinanciamiento> selectByExample(TFuenteFinanciamientoExample example);

    TFuenteFinanciamiento selectByPrimaryKey(TFuenteFinanciamientoKey key);

    int updateByExampleSelective(@Param("record") TFuenteFinanciamiento record, @Param("example") TFuenteFinanciamientoExample example);

    int updateByExample(@Param("record") TFuenteFinanciamiento record, @Param("example") TFuenteFinanciamientoExample example);

    int updateByPrimaryKeySelective(TFuenteFinanciamiento record);

    int updateByPrimaryKey(TFuenteFinanciamiento record);
}