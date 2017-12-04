package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TRegimenPensionarioHistorial;
import sernanp.app.dao.domain.TRegimenPensionarioHistorialExample;
import sernanp.app.dao.domain.TRegimenPensionarioHistorialKey;

public interface TRegimenPensionarioHistorialMapper {
    int countByExample(TRegimenPensionarioHistorialExample example);

    int deleteByExample(TRegimenPensionarioHistorialExample example);

    int deleteByPrimaryKey(TRegimenPensionarioHistorialKey key);

    int insert(TRegimenPensionarioHistorial record);

    int insertSelective(TRegimenPensionarioHistorial record);

    List<TRegimenPensionarioHistorial> selectByExample(TRegimenPensionarioHistorialExample example);

    TRegimenPensionarioHistorial selectByPrimaryKey(TRegimenPensionarioHistorialKey key);

    int updateByExampleSelective(@Param("record") TRegimenPensionarioHistorial record, @Param("example") TRegimenPensionarioHistorialExample example);

    int updateByExample(@Param("record") TRegimenPensionarioHistorial record, @Param("example") TRegimenPensionarioHistorialExample example);

    int updateByPrimaryKeySelective(TRegimenPensionarioHistorial record);

    int updateByPrimaryKey(TRegimenPensionarioHistorial record);
}