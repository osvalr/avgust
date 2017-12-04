package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TDireccionDomicilioHistorial;
import sernanp.app.dao.domain.TDireccionDomicilioHistorialExample;
import sernanp.app.dao.domain.TDireccionDomicilioHistorialKey;

public interface TDireccionDomicilioHistorialMapper {
    int countByExample(TDireccionDomicilioHistorialExample example);

    int deleteByExample(TDireccionDomicilioHistorialExample example);

    int deleteByPrimaryKey(TDireccionDomicilioHistorialKey key);

    int insert(TDireccionDomicilioHistorial record);

    int insertSelective(TDireccionDomicilioHistorial record);

    List<TDireccionDomicilioHistorial> selectByExample(TDireccionDomicilioHistorialExample example);

    TDireccionDomicilioHistorial selectByPrimaryKey(TDireccionDomicilioHistorialKey key);

    int updateByExampleSelective(@Param("record") TDireccionDomicilioHistorial record, @Param("example") TDireccionDomicilioHistorialExample example);

    int updateByExample(@Param("record") TDireccionDomicilioHistorial record, @Param("example") TDireccionDomicilioHistorialExample example);

    int updateByPrimaryKeySelective(TDireccionDomicilioHistorial record);

    int updateByPrimaryKey(TDireccionDomicilioHistorial record);
}