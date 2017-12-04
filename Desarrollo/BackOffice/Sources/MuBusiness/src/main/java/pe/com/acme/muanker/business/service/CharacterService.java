package pe.com.acme.muanker.business.service;

import java.util.List;

import pe.com.acme.query.mybatis.model.CharacterQuery;
import pe.com.acme.util.IMybatisRepositoryHelper;

public interface CharacterService extends IMybatisRepositoryHelper {
	void resetCharacter(String AccountID, String NameCharacter) throws Exception;
	void addPoints(String AccountID, String NameCharacter, Integer str, Integer vit, Integer ene, Integer dex) throws Exception;
	void pkClear(String AccountID, String NameCharacter) throws Exception;
	List<CharacterQuery> charactersByAccountId(String AccountID) throws Exception;
}
