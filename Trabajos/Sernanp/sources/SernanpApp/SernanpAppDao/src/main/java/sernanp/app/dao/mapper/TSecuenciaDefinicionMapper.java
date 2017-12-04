package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TSecuenciaDefinicion;
import sernanp.app.dao.domain.TSecuenciaDefinicionExample;
import sernanp.app.dao.domain.TSecuenciaDefinicionKey;

public interface TSecuenciaDefinicionMapper {
    int countByExample(TSecuenciaDefinicionExample example);

    int deleteByExample(TSecuenciaDefinicionExample example);

    int deleteByPrimaryKey(TSecuenciaDefinicionKey key);

    int insert(TSecuenciaDefinicion record);

    int insertSelective(TSecuenciaDefinicion record);

    List<TSecuenciaDefinicion> selectByExample(TSecuenciaDefinicionExample example);

    TSecuenciaDefinicion selectByPrimaryKey(TSecuenciaDefinicionKey key);

    int updateByExampleSelective(@Param("record") TSecuenciaDefinicion record, @Param("example") TSecuenciaDefinicionExample example);

    int updateByExample(@Param("record") TSecuenciaDefinicion record, @Param("example") TSecuenciaDefinicionExample example);

    int updateByPrimaryKeySelective(TSecuenciaDefinicion record);

    int updateByPrimaryKey(TSecuenciaDefinicion record);
}