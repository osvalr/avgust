package sernanp.app.business.dto;

import sernanp.app.dao.query.domain.InfoAdendaQuery;
import sernanp.app.dao.query.domain.InfoContratoAdendaQuery;
import sernanp.app.dao.query.domain.InfoContratoQuery;
import sernanp.app.dao.query.domain.InfoResponsableSernanp;
import sernanp.app.dao.query.domain.InfoResponsableUnidadOperativaQuery;
import sernanp.app.dao.query.domain.InfoTrabajadorQuery;

public class GenerateDocDto {
	private InfoContratoQuery contrato;
	private InfoContratoAdendaQuery contratoAdenda;
	private InfoResponsableUnidadOperativaQuery responsable;
	private InfoTrabajadorQuery trabajador;
	private InfoAdendaQuery adenda;
	private InfoResponsableSernanp responsableSernanp;
	private String pathTemplate;
	private String pathRutaTmp;
	private Integer idContrato;
	private String pathTmpDocx;
	private String pathTmpPdf;

	public InfoContratoQuery getContrato() {
		return contrato;
	}

	public void setContrato(InfoContratoQuery contrato) {
		this.contrato = contrato;
	}

	public InfoResponsableUnidadOperativaQuery getResponsable() {
		return responsable;
	}

	public void setResponsable(InfoResponsableUnidadOperativaQuery responsable) {
		this.responsable = responsable;
	}

	public InfoTrabajadorQuery getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(InfoTrabajadorQuery trabajador) {
		this.trabajador = trabajador;
	}

	public String getPathTemplate() {
		return pathTemplate;
	}

	public void setPathTemplate(String pathTemplate) {
		this.pathTemplate = pathTemplate;
	}

	public String getPathRutaTmp() {
		return pathRutaTmp;
	}

	public void setPathRutaTmp(String pathRutaTmp) {
		this.pathRutaTmp = pathRutaTmp;
	}

	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public String getPathTmpDocx() {
		return pathTmpDocx;
	}

	public void setPathTmpDocx(String pathTmpDocx) {
		this.pathTmpDocx = pathTmpDocx;
	}

	public String getPathTmpPdf() {
		return pathTmpPdf;
	}

	public void setPathTmpPdf(String pathTmpPdf) {
		this.pathTmpPdf = pathTmpPdf;
	}

	public InfoAdendaQuery getAdenda() {
		return adenda;
	}

	public void setAdenda(InfoAdendaQuery adenda) {
		this.adenda = adenda;
	}

	public InfoResponsableSernanp getResponsableSernanp() {
		return responsableSernanp;
	}

	public void setResponsableSernanp(InfoResponsableSernanp responsableSernanp) {
		this.responsableSernanp = responsableSernanp;
	}

	public InfoContratoAdendaQuery getContratoAdenda() {
		return contratoAdenda;
	}

	public void setContratoAdenda(InfoContratoAdendaQuery contratoAdenda) {
		this.contratoAdenda = contratoAdenda;
	}

}
