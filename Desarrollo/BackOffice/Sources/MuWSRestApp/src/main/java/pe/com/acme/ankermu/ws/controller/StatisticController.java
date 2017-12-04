package pe.com.acme.ankermu.ws.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.acme.muanker.business.service.CharacterService;
import pe.com.acme.query.mybatis.mapper.CharactersForResetsQueryMapper;
import pe.com.acme.query.mybatis.mapper.CharactersOnlineQueryMapper;
import pe.com.acme.query.mybatis.mapper.GuildsForScoreQueryMapper;
import pe.com.acme.query.mybatis.model.CharactersForResetsQuery;
import pe.com.acme.query.mybatis.model.CharactersForResetsQueryCriteria;
import pe.com.acme.query.mybatis.model.CharactersOnlineQuery;
import pe.com.acme.query.mybatis.model.CharactersOnlineQueryCriteria;
import pe.com.acme.query.mybatis.model.GuildsForScoreQuery;
import pe.com.acme.query.mybatis.model.GuildsForScoreQueryCriteria;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.web.ControllerHelper;

@Controller
@RequestMapping("/Statistic")
public class StatisticController extends ControllerHelper {
	
	private static Logger log = Logger.getLogger(StatisticController.class);
	
	@Autowired
	private CharacterService characterService;
	
	@RequestMapping(value="charactersOnline")
	public @ResponseBody Map<String,? extends Object> charactersOnline(HttpServletRequest request) {
		
		try{
			
			CharactersOnlineQueryCriteria criteria = this.loadCriteria(request, CharactersOnlineQueryCriteria.class);
			
            List<CharactersOnlineQuery> list = characterService.selectByQuery(CharactersOnlineQueryMapper.class, criteria, criteria.getStart(), criteria.getLimit());
            int count = characterService.selectCountByQuery(CharactersOnlineQueryMapper.class, criteria);
			return JsonReturnUtil.success(list,count);
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="charactersForResets")
	public @ResponseBody Map<String,? extends Object> charactersForResets(HttpServletRequest request) {
		
		try{
			
			CharactersForResetsQueryCriteria criteria = this.loadCriteria(request, CharactersForResetsQueryCriteria.class);
			
            List<CharactersForResetsQuery> list = characterService.selectByQuery(CharactersForResetsQueryMapper.class, criteria, criteria.getStart(), criteria.getLimit());
            int count = characterService.selectCountByQuery(CharactersForResetsQueryMapper.class, criteria);
			return JsonReturnUtil.success(list,count);
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="guildsForScore")
	public @ResponseBody Map<String,? extends Object> guildsForScore(HttpServletRequest request) {
		
		try{
			
			GuildsForScoreQueryCriteria criteria = this.loadCriteria(request, GuildsForScoreQueryCriteria.class);
			
            List<GuildsForScoreQuery> list = characterService.selectByQuery(GuildsForScoreQueryMapper.class, criteria, criteria.getStart(), criteria.getLimit());
            int count = characterService.selectCountByQuery(GuildsForScoreQueryMapper.class, criteria);
			return JsonReturnUtil.success(list,count);
			
		} catch (Exception e) {
            log.error(e.getMessage(),e);
			return JsonReturnUtil.exception(e.getMessage());
		}
	}
}
