package pe.com.acme.domain.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pe.com.acme.domain.mybatis.model.Character;
import pe.com.acme.domain.mybatis.model.CharacterExample;
import pe.com.acme.domain.mybatis.model.CharacterKey;
import pe.com.acme.domain.mybatis.model.CharacterWithBLOBs;

public interface CharacterMapper {
    int countByExample(CharacterExample example);

    int deleteByExample(CharacterExample example);

    int deleteByPrimaryKey(CharacterKey key);

    int insert(CharacterWithBLOBs record);

    int insertSelective(CharacterWithBLOBs record);

    List<CharacterWithBLOBs> selectByExampleWithBLOBsWithRowbounds(CharacterExample example, RowBounds rowBounds);

    List<CharacterWithBLOBs> selectByExampleWithBLOBs(CharacterExample example);

    List<Character> selectByExampleWithRowbounds(CharacterExample example, RowBounds rowBounds);

    List<Character> selectByExample(CharacterExample example);

    CharacterWithBLOBs selectByPrimaryKey(CharacterKey key);

    int updateByExampleSelective(@Param("record") CharacterWithBLOBs record, @Param("example") CharacterExample example);

    int updateByExampleWithBLOBs(@Param("record") CharacterWithBLOBs record, @Param("example") CharacterExample example);

    int updateByExample(@Param("record") Character record, @Param("example") CharacterExample example);

    int updateByPrimaryKeySelective(CharacterWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CharacterWithBLOBs record);

    int updateByPrimaryKey(Character record);
}