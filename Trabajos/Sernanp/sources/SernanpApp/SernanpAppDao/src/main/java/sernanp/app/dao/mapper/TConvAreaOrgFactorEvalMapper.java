package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TConvAreaOrgFactorEval;
import sernanp.app.dao.domain.TConvAreaOrgFactorEvalExample;
import sernanp.app.dao.domain.TConvAreaOrgFactorEvalKey;

public interface TConvAreaOrgFactorEvalMapper {
    int countByExample(TConvAreaOrgFactorEvalExample example);

    int deleteByExample(TConvAreaOrgFactorEvalExample example);

    int deleteByPrimaryKey(TConvAreaOrgFactorEvalKey key);

    int insert(TConvAreaOrgFactorEval record);

    int insertSelective(TConvAreaOrgFactorEval record);

    List<TConvAreaOrgFactorEval> selectByExampleWithRowbounds(TConvAreaOrgFactorEvalExample example, RowBounds rowBounds);

    List<TConvAreaOrgFactorEval> selectByExample(TConvAreaOrgFactorEvalExample example);

    TConvAreaOrgFactorEval selectByPrimaryKey(TConvAreaOrgFactorEvalKey key);

    int updateByExampleSelective(@Param("record") TConvAreaOrgFactorEval record, @Param("example") TConvAreaOrgFactorEvalExample example);

    int updateByExample(@Param("record") TConvAreaOrgFactorEval record, @Param("example") TConvAreaOrgFactorEvalExample example);

    int updateByPrimaryKeySelective(TConvAreaOrgFactorEval record);

    int updateByPrimaryKey(TConvAreaOrgFactorEval record);
}