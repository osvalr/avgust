package pe.com.acme.muanker.business.implement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.acme.domain.mybatis.mapper.CharacterMapper;
import pe.com.acme.domain.mybatis.mapper.ResetHistoricoMapper;
import pe.com.acme.domain.mybatis.model.Character;
import pe.com.acme.domain.mybatis.model.CharacterExample;
import pe.com.acme.domain.mybatis.model.ResetHistorico;
import pe.com.acme.muanker.business.service.CharacterService;
import pe.com.acme.muanker.business.util.MuWebConstantes;
import pe.com.acme.query.mybatis.mapper.CharacterQueryMapper;
import pe.com.acme.query.mybatis.model.CharacterQuery;
import pe.com.acme.query.mybatis.model.CharacterQueryCriteria;
import pe.com.acme.util.MybatisRepositoryHelper;

@Service
public class CharacterServiceImpl extends MybatisRepositoryHelper implements CharacterService {

	@Autowired
	CharacterMapper characterMapper;
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void resetCharacter(String AccountID, String NameCharacter) throws Exception {
		
		if(AccountID == null){
			throw new Exception("Account Id must not be null, Log In Please.");
		}
		if(NameCharacter == null){
			throw new Exception("Charactoer name must not be null.");
		}
		
		CharacterExample characterExample = new CharacterExample();
		characterExample.createCriteria().andAccountIDEqualTo(AccountID).andNameEqualTo(NameCharacter);
		
		Character character = this.getRecord(characterMapper.selectByExample(characterExample));
		
		if(character.getMoney().intValue() < MuWebConstantes.RESET_MONEY_REQUIERED){
			throw new Exception("You do not have enough zen, necessary ("+MuWebConstantes.RESET_MONEY_REQUIERED+").");
		}
		
		if(character.getcLevel().intValue() < MuWebConstantes.RESET_LEVEL_REQUIRED){
			throw new Exception("You do not have enough level, necessary ("+MuWebConstantes.RESET_LEVEL_REQUIRED+").");
		}
		
		character.setMoney(character.getMoney().intValue() - MuWebConstantes.RESET_MONEY_REQUIERED);
		character.setcLevel(1);
		character.setStrength(25);
		character.setDexterity(25);
		character.setVitality(25);
		character.setEnergy(25);
		character.setResets((character.getResets().intValue() + 1));
		character.setLevelUpPoint(character.getResets().intValue() * MuWebConstantes.POINTS_PER_RESET);
		
		characterMapper.updateByPrimaryKey(character);
		
		ResetHistorico resetHistorico = new ResetHistorico();
		resetHistorico.setAccountID(AccountID);
		resetHistorico.setNameCharacter(NameCharacter);
		resetHistorico.setFecha_registro(new Date());
		
		this.insertSelective(ResetHistoricoMapper.class, resetHistorico);
		
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void addPoints(String AccountID, String NameCharacter, Integer str, Integer vit, Integer ene, Integer dex) throws Exception {
		
		if (str == null) {
			str = new Integer(0);
		}

		if (vit == null) {
			vit = new Integer(0);
		}

		if (ene == null) {
			ene = new Integer(0);
		}

		if (dex == null) {
			dex = new Integer(0);
		}
		
		if(AccountID == null){
			throw new Exception("Account Id must not be null, Log In Please.");
		}
		if(NameCharacter == null || NameCharacter.equals("")){
			throw new Exception("Charactoer name must not be null.");
		}
		
		CharacterExample characterExample = new CharacterExample();
		characterExample.createCriteria().andAccountIDEqualTo(AccountID).andNameEqualTo(NameCharacter);
		
		Character character = this.getRecord(characterMapper.selectByExample(characterExample));
		
		int total_points = str.intValue() + vit.intValue() + ene.intValue() + dex.intValue();
		
		if(total_points > character.getLevelUpPoint().intValue()){
			throw new Exception("The total points for adding exceeds the total points available. (points available = " + character.getLevelUpPoint() +")");
		}
		
		character.setLevelUpPoint(character.getLevelUpPoint().intValue() - total_points);
		character.setStrength(character.getStrength().intValue() + str.intValue());
		character.setDexterity(character.getDexterity().intValue() + dex.intValue());
		character.setEnergy(character.getEnergy().intValue() + ene.intValue());
		character.setVitality(character.getVitality().intValue() + vit.intValue());
		
		if(character.getStrength().intValue() > 65535){
			throw new Exception("The Strength exceeds 65535 points allowed.");
		}
		
		if(character.getDexterity().intValue() > 65535){
			throw new Exception("The Dexterity exceeds 65535 points allowed.");
		}
		
		if(character.getEnergy().intValue() > 65535){
			throw new Exception("The Energy exceeds 65535 points allowed.");
		}
		
		if(character.getVitality().intValue() > 65535){
			throw new Exception("The Vitality exceeds 65535 points allowed.");
		}
		
		characterMapper.updateByPrimaryKey(character);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T getRecord(List list){
		if(list.isEmpty()){
			return null;
		}else{
			return (T) list.get(0);
		}
	}

	@Override
	public List<CharacterQuery> charactersByAccountId(String AccountID) throws Exception {
		
		if(AccountID == null){
			throw new Exception("Account Id must not be null, Log In Please.");
		}
		
		CharacterQueryCriteria criteria = new CharacterQueryCriteria();
		criteria.setAccountID(AccountID);
		
		List<CharacterQuery> list = this.selectByQuery(CharacterQueryMapper.class, criteria);
		
		return list;
		
	}
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void pkClear(String AccountID, String NameCharacter) throws Exception {
		
		if(AccountID == null){
			throw new Exception("Account Id must not be null, Log In Please.");
		}
		if(NameCharacter == null){
			throw new Exception("Charactoer name must not be null.");
		}
		
		CharacterExample characterExample = new CharacterExample();
		characterExample.createCriteria().andAccountIDEqualTo(AccountID).andNameEqualTo(NameCharacter);
		
		Character character = this.getRecord(characterMapper.selectByExample(characterExample));
		
		if(character.getMoney().intValue() < MuWebConstantes.PKCLEAR_MONEY_REQUIERED){
			throw new Exception("You do not have enough zen, necessary ("+MuWebConstantes.PKCLEAR_MONEY_REQUIERED+").");
		}
		
		character.setMoney(character.getMoney().intValue() - MuWebConstantes.RESET_MONEY_REQUIERED);
		character.setPklevel(3);
		character.setPkcount(0);
		
		characterExample = new CharacterExample();
		characterExample.createCriteria().andAccountIDEqualTo(AccountID).andNameEqualTo(NameCharacter).andPkLevelGreaterThan(3);
		
		characterMapper.updateByExample(character,characterExample);
		
	}
}
