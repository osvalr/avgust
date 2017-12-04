package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Pais;
import sernanp.app.dao.domain.PaisExample;
import sernanp.app.dao.domain.PaisKey;

public interface PaisMapper {
    int countByExample(PaisExample example);

    int deleteByExample(PaisExample example);

    int deleteByPrimaryKey(PaisKey key);

    int insert(Pais record);

    int insertSelective(Pais record);

    List<Pais> selectByExample(PaisExample example);

    Pais selectByPrimaryKey(PaisKey key);

    int updateByExampleSelective(@Param("record") Pais record, @Param("example") PaisExample example);

    int updateByExample(@Param("record") Pais record, @Param("example") PaisExample example);

    int updateByPrimaryKeySelective(Pais record);

    int updateByPrimaryKey(Pais record);
}