package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TTipoProfesion;
import sernanp.app.dao.domain.TTipoProfesionExample;
import sernanp.app.dao.domain.TTipoProfesionKey;

public interface TTipoProfesionMapper {
    int countByExample(TTipoProfesionExample example);

    int deleteByExample(TTipoProfesionExample example);

    int deleteByPrimaryKey(TTipoProfesionKey key);

    int insert(TTipoProfesion record);

    int insertSelective(TTipoProfesion record);

    List<TTipoProfesion> selectByExample(TTipoProfesionExample example);

    TTipoProfesion selectByPrimaryKey(TTipoProfesionKey key);

    int updateByExampleSelective(@Param("record") TTipoProfesion record, @Param("example") TTipoProfesionExample example);

    int updateByExample(@Param("record") TTipoProfesion record, @Param("example") TTipoProfesionExample example);

    int updateByPrimaryKeySelective(TTipoProfesion record);

    int updateByPrimaryKey(TTipoProfesion record);
}