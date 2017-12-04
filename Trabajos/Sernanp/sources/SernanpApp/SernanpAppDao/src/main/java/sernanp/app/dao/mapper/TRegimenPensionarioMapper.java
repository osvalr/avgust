package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TRegimenPensionario;
import sernanp.app.dao.domain.TRegimenPensionarioExample;
import sernanp.app.dao.domain.TRegimenPensionarioKey;

public interface TRegimenPensionarioMapper {
    int countByExample(TRegimenPensionarioExample example);

    int deleteByExample(TRegimenPensionarioExample example);

    int deleteByPrimaryKey(TRegimenPensionarioKey key);

    int insert(TRegimenPensionario record);

    int insertSelective(TRegimenPensionario record);

    List<TRegimenPensionario> selectByExample(TRegimenPensionarioExample example);

    TRegimenPensionario selectByPrimaryKey(TRegimenPensionarioKey key);

    int updateByExampleSelective(@Param("record") TRegimenPensionario record, @Param("example") TRegimenPensionarioExample example);

    int updateByExample(@Param("record") TRegimenPensionario record, @Param("example") TRegimenPensionarioExample example);

    int updateByPrimaryKeySelective(TRegimenPensionario record);

    int updateByPrimaryKey(TRegimenPensionario record);
}