package sernanp.app.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import sernanp.app.dao.domain.TSuspensionCuartaCategoria;
import sernanp.app.dao.domain.TSuspensionCuartaCategoriaExample;
import sernanp.app.dao.domain.TSuspensionCuartaCategoriaKey;

public interface TSuspensionCuartaCategoriaMapper {
    int countByExample(TSuspensionCuartaCategoriaExample example);

    int deleteByExample(TSuspensionCuartaCategoriaExample example);

    int deleteByPrimaryKey(TSuspensionCuartaCategoriaKey key);

    int insert(TSuspensionCuartaCategoria record);

    int insertSelective(TSuspensionCuartaCategoria record);

    List<TSuspensionCuartaCategoria> selectByExampleWithRowbounds(TSuspensionCuartaCategoriaExample example, RowBounds rowBounds);

    List<TSuspensionCuartaCategoria> selectByExample(TSuspensionCuartaCategoriaExample example);

    TSuspensionCuartaCategoria selectByPrimaryKey(TSuspensionCuartaCategoriaKey key);

    int updateByExampleSelective(@Param("record") TSuspensionCuartaCategoria record, @Param("example") TSuspensionCuartaCategoriaExample example);

    int updateByExample(@Param("record") TSuspensionCuartaCategoria record, @Param("example") TSuspensionCuartaCategoriaExample example);

    int updateByPrimaryKeySelective(TSuspensionCuartaCategoria record);

    int updateByPrimaryKey(TSuspensionCuartaCategoria record);
}