package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Areanatural;
import sernanp.app.dao.domain.AreanaturalExample;
import sernanp.app.dao.domain.AreanaturalKey;

public interface AreanaturalMapper {
    int countByExample(AreanaturalExample example);

    int deleteByExample(AreanaturalExample example);

    int deleteByPrimaryKey(AreanaturalKey key);

    int insert(Areanatural record);

    int insertSelective(Areanatural record);

    List<Areanatural> selectByExample(AreanaturalExample example);

    Areanatural selectByPrimaryKey(AreanaturalKey key);

    int updateByExampleSelective(@Param("record") Areanatural record, @Param("example") AreanaturalExample example);

    int updateByExample(@Param("record") Areanatural record, @Param("example") AreanaturalExample example);

    int updateByPrimaryKeySelective(Areanatural record);

    int updateByPrimaryKey(Areanatural record);
}