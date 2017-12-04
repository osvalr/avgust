package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TTipificacion;
import sernanp.app.dao.domain.TTipificacionExample;
import sernanp.app.dao.domain.TTipificacionKey;

public interface TTipificacionMapper {
    int countByExample(TTipificacionExample example);

    int deleteByExample(TTipificacionExample example);

    int deleteByPrimaryKey(TTipificacionKey key);

    int insert(TTipificacion record);

    int insertSelective(TTipificacion record);

    List<TTipificacion> selectByExample(TTipificacionExample example);

    TTipificacion selectByPrimaryKey(TTipificacionKey key);

    int updateByExampleSelective(@Param("record") TTipificacion record, @Param("example") TTipificacionExample example);

    int updateByExample(@Param("record") TTipificacion record, @Param("example") TTipificacionExample example);

    int updateByPrimaryKeySelective(TTipificacion record);

    int updateByPrimaryKey(TTipificacion record);
}