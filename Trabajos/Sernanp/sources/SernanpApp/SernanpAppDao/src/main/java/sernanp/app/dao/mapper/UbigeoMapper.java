package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sernanp.app.dao.domain.Ubigeo;
import sernanp.app.dao.domain.UbigeoExample;
import sernanp.app.dao.domain.UbigeoKey;

public interface UbigeoMapper {
    int countByExample(UbigeoExample example);

    int deleteByExample(UbigeoExample example);

    int deleteByPrimaryKey(UbigeoKey key);

    int insert(Ubigeo record);

    int insertSelective(Ubigeo record);

    List<Ubigeo> selectByExample(UbigeoExample example);

    Ubigeo selectByPrimaryKey(UbigeoKey key);

    int updateByExampleSelective(@Param("record") Ubigeo record, @Param("example") UbigeoExample example);

    int updateByExample(@Param("record") Ubigeo record, @Param("example") UbigeoExample example);

    int updateByPrimaryKeySelective(Ubigeo record);

    int updateByPrimaryKey(Ubigeo record);
}