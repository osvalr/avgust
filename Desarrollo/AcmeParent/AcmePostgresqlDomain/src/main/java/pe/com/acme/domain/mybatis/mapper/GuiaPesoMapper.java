package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.GuiaPeso;
import pe.com.acme.domain.mybatis.model.GuiaPesoExample;
import pe.com.acme.domain.mybatis.model.GuiaPesoKey;

public interface GuiaPesoMapper {
    int countByExample(GuiaPesoExample example);

    int deleteByExample(GuiaPesoExample example);

    int deleteByPrimaryKey(GuiaPesoKey key);

    int insert(GuiaPeso record);

    int insertSelective(GuiaPeso record);

    List<GuiaPeso> selectByExampleWithRowbounds(GuiaPesoExample example, RowBounds rowBounds);

    List<GuiaPeso> selectByExample(GuiaPesoExample example);

    GuiaPeso selectByPrimaryKey(GuiaPesoKey key);

    int updateByExampleSelective(@Param("record") GuiaPeso record, @Param("example") GuiaPesoExample example);

    int updateByExample(@Param("record") GuiaPeso record, @Param("example") GuiaPesoExample example);

    int updateByPrimaryKeySelective(GuiaPeso record);

    int updateByPrimaryKey(GuiaPeso record);
}