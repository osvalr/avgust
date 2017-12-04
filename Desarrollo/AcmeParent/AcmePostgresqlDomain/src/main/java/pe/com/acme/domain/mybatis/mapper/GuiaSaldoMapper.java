package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.GuiaSaldo;
import pe.com.acme.domain.mybatis.model.GuiaSaldoExample;
import pe.com.acme.domain.mybatis.model.GuiaSaldoKey;

public interface GuiaSaldoMapper {
    int countByExample(GuiaSaldoExample example);

    int deleteByExample(GuiaSaldoExample example);

    int deleteByPrimaryKey(GuiaSaldoKey key);

    int insert(GuiaSaldo record);

    int insertSelective(GuiaSaldo record);

    List<GuiaSaldo> selectByExampleWithRowbounds(GuiaSaldoExample example, RowBounds rowBounds);

    List<GuiaSaldo> selectByExample(GuiaSaldoExample example);

    GuiaSaldo selectByPrimaryKey(GuiaSaldoKey key);

    int updateByExampleSelective(@Param("record") GuiaSaldo record, @Param("example") GuiaSaldoExample example);

    int updateByExample(@Param("record") GuiaSaldo record, @Param("example") GuiaSaldoExample example);

    int updateByPrimaryKeySelective(GuiaSaldo record);

    int updateByPrimaryKey(GuiaSaldo record);
}