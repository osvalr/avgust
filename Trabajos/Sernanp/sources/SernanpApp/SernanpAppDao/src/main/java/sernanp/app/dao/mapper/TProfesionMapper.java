package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TProfesion;
import sernanp.app.dao.domain.TProfesionExample;
import sernanp.app.dao.domain.TProfesionKey;

public interface TProfesionMapper {
    int countByExample(TProfesionExample example);

    int deleteByExample(TProfesionExample example);

    int deleteByPrimaryKey(TProfesionKey key);

    int insert(TProfesion record);

    int insertSelective(TProfesion record);

    List<TProfesion> selectByExample(TProfesionExample example);

    TProfesion selectByPrimaryKey(TProfesionKey key);

    int updateByExampleSelective(@Param("record") TProfesion record, @Param("example") TProfesionExample example);

    int updateByExample(@Param("record") TProfesion record, @Param("example") TProfesionExample example);

    int updateByPrimaryKeySelective(TProfesion record);

    int updateByPrimaryKey(TProfesion record);
}