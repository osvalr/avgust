package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrg;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgExample;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgKey;

public interface TPostulanteCnvAreaOrgMapper {
    int countByExample(TPostulanteCnvAreaOrgExample example);

    int deleteByExample(TPostulanteCnvAreaOrgExample example);

    int deleteByPrimaryKey(TPostulanteCnvAreaOrgKey key);

    int insert(TPostulanteCnvAreaOrg record);

    int insertSelective(TPostulanteCnvAreaOrg record);

    List<TPostulanteCnvAreaOrg> selectByExampleWithRowbounds(TPostulanteCnvAreaOrgExample example, RowBounds rowBounds);

    List<TPostulanteCnvAreaOrg> selectByExample(TPostulanteCnvAreaOrgExample example);

    TPostulanteCnvAreaOrg selectByPrimaryKey(TPostulanteCnvAreaOrgKey key);

    int updateByExampleSelective(@Param("record") TPostulanteCnvAreaOrg record, @Param("example") TPostulanteCnvAreaOrgExample example);

    int updateByExample(@Param("record") TPostulanteCnvAreaOrg record, @Param("example") TPostulanteCnvAreaOrgExample example);

    int updateByPrimaryKeySelective(TPostulanteCnvAreaOrg record);

    int updateByPrimaryKey(TPostulanteCnvAreaOrg record);
}