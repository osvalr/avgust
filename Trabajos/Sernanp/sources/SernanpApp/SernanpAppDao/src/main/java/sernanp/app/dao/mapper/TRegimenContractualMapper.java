package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.TRegimenContractual;
import sernanp.app.dao.domain.TRegimenContractualExample;
import sernanp.app.dao.domain.TRegimenContractualKey;

public interface TRegimenContractualMapper {
    int countByExample(TRegimenContractualExample example);

    int deleteByExample(TRegimenContractualExample example);

    int deleteByPrimaryKey(TRegimenContractualKey key);

    int insert(TRegimenContractual record);

    int insertSelective(TRegimenContractual record);

    List<TRegimenContractual> selectByExample(TRegimenContractualExample example);

    TRegimenContractual selectByPrimaryKey(TRegimenContractualKey key);

    int updateByExampleSelective(@Param("record") TRegimenContractual record, @Param("example") TRegimenContractualExample example);

    int updateByExample(@Param("record") TRegimenContractual record, @Param("example") TRegimenContractualExample example);

    int updateByPrimaryKeySelective(TRegimenContractual record);

    int updateByPrimaryKey(TRegimenContractual record);
}