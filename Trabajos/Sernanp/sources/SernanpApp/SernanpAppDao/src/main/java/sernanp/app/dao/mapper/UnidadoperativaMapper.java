package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Unidadoperativa;
import sernanp.app.dao.domain.UnidadoperativaExample;
import sernanp.app.dao.domain.UnidadoperativaKey;

public interface UnidadoperativaMapper {
    int countByExample(UnidadoperativaExample example);

    int deleteByExample(UnidadoperativaExample example);

    int deleteByPrimaryKey(UnidadoperativaKey key);

    int insert(Unidadoperativa record);

    int insertSelective(Unidadoperativa record);

    List<Unidadoperativa> selectByExample(UnidadoperativaExample example);

    Unidadoperativa selectByPrimaryKey(UnidadoperativaKey key);

    int updateByExampleSelective(@Param("record") Unidadoperativa record, @Param("example") UnidadoperativaExample example);

    int updateByExample(@Param("record") Unidadoperativa record, @Param("example") UnidadoperativaExample example);

    int updateByPrimaryKeySelective(Unidadoperativa record);

    int updateByPrimaryKey(Unidadoperativa record);
}