package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TClasificador;
import sernanp.app.dao.domain.TClasificadorExample;
import sernanp.app.dao.domain.TClasificadorKey;

public interface TClasificadorMapper {
    int countByExample(TClasificadorExample example);

    int deleteByExample(TClasificadorExample example);

    int deleteByPrimaryKey(TClasificadorKey key);

    int insert(TClasificador record);

    int insertSelective(TClasificador record);

    List<TClasificador> selectByExampleWithRowbounds(TClasificadorExample example, RowBounds rowBounds);

    List<TClasificador> selectByExample(TClasificadorExample example);

    TClasificador selectByPrimaryKey(TClasificadorKey key);

    int updateByExampleSelective(@Param("record") TClasificador record, @Param("example") TClasificadorExample example);

    int updateByExample(@Param("record") TClasificador record, @Param("example") TClasificadorExample example);

    int updateByPrimaryKeySelective(TClasificador record);

    int updateByPrimaryKey(TClasificador record);
}