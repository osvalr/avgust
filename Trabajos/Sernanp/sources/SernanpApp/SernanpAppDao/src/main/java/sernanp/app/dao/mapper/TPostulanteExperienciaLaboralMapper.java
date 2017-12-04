package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TPostulanteExperienciaLaboral;
import sernanp.app.dao.domain.TPostulanteExperienciaLaboralExample;
import sernanp.app.dao.domain.TPostulanteExperienciaLaboralKey;

public interface TPostulanteExperienciaLaboralMapper {
    int countByExample(TPostulanteExperienciaLaboralExample example);

    int deleteByExample(TPostulanteExperienciaLaboralExample example);

    int deleteByPrimaryKey(TPostulanteExperienciaLaboralKey key);

    int insert(TPostulanteExperienciaLaboral record);

    int insertSelective(TPostulanteExperienciaLaboral record);

    List<TPostulanteExperienciaLaboral> selectByExample(TPostulanteExperienciaLaboralExample example);

    TPostulanteExperienciaLaboral selectByPrimaryKey(TPostulanteExperienciaLaboralKey key);

    int updateByExampleSelective(@Param("record") TPostulanteExperienciaLaboral record, @Param("example") TPostulanteExperienciaLaboralExample example);

    int updateByExample(@Param("record") TPostulanteExperienciaLaboral record, @Param("example") TPostulanteExperienciaLaboralExample example);

    int updateByPrimaryKeySelective(TPostulanteExperienciaLaboral record);

    int updateByPrimaryKey(TPostulanteExperienciaLaboral record);
}