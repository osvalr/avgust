/*
* Copyright «©» 2018, SENAMHI All rights reserved.
*
* This file was generated by MybatisModelGenerator v.4.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.4.0] by JRaffo 
*/


/**
* The DocumentoVentaDetalleQuery class is the resultset equivalent of an SQL query
* for Java and will be managed by Mybatis.
*
* @author  Javier Raffo
* @version 1.0
* @since   05/01/2018 20:36:42
*/

package pe.com.kapcom.facturador.ws.model.mybatis.bean;


import pe.com.kapcom.util.BaseModel;

public class DocumentoVentaDetalleQuery extends BaseModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.String ventas_key; 
	private java.lang.String fecemision; 
	private java.lang.String emp_descri; 
	private java.lang.String emp_siglas; 
	private java.lang.String emp_direc; 
	private java.lang.String emp_ruc; 
	private java.lang.String emp_telef; 
	private java.lang.String emp_email; 
	private java.lang.String emp_web; 
	private java.lang.String cod_hash; 
	private java.lang.String docformato; 
	private java.lang.String docnombre; 
	private java.lang.String pdf147; 
	private java.lang.String condvta_id; 
	private java.lang.String condvta_des; 
	private java.lang.String vend_id; 
	private java.lang.String vend_des; 
	private java.lang.String lis_id; 
	private java.lang.String lis_des; 
	private java.lang.String clie_id; 
	private java.lang.String clie_des; 
	private java.lang.String dir_ent; 
	private java.lang.String pedido; 
	private java.lang.String nroguia; 
	private java.lang.String r_leyenda_monto_letras; 
	private java.lang.String fecentrega; 
	private java.lang.String zona_id; 
	private java.math.BigDecimal totperc; 
	private java.lang.String zona_des; 
	private java.lang.String trans_id; 
	private java.lang.String trans_des; 
	private java.lang.String trans_placa; 
	private java.lang.String trans_ruc; 
	private java.lang.String trans_marca; 
	private java.lang.String trans_licencia; 
	private java.lang.String chofer; 
	private java.lang.String moneda; 
	private java.math.BigDecimal tipocambio; 
	private java.lang.String ruc; 
	private java.lang.String rucdni; 
	private java.lang.String docidentidad; 
	private java.lang.String documentokey; 
	private java.lang.String emp_id; 
	private java.lang.String periodo; 
	private java.lang.String correo; 
	private java.lang.String art_id; 
	private java.lang.String art_des; 
	private java.lang.String tipafec; 
	private java.lang.String art_unimedsun; 
	private java.lang.String tipitem; 
	private java.lang.String op_grava; 
	private java.lang.String op_gratuitas; 
	private java.lang.String op_exone; 
	private java.lang.String op_inafe; 
	private java.lang.String desc_total; 
	private java.lang.String igv_total; 
	private java.lang.String isc_total; 
	private java.lang.String total_pagar; 
	private java.math.BigDecimal cantped; 
	private java.math.BigDecimal preunit; 
	private java.math.BigDecimal valventa; 
	private java.math.BigDecimal pordesc; 
	private java.math.BigDecimal totdesc; 
	private java.math.BigDecimal valafec; 
	private java.math.BigDecimal porimp; 
	private java.math.BigDecimal valimp; 
	private java.math.BigDecimal valperc; 
	private java.math.BigDecimal preventa; 
	private java.math.BigDecimal preventaperc; 
	private java.lang.String url_web; 
	private java.lang.String tipooperacion; 
	private java.lang.String codigo_qr; 
	private java.lang.String pesototal; 
	private java.lang.String unidadpeso;

    private String ruta_logo;
    private String ruta_qr;


	public java.lang.String getVentas_key() { 
	  return ventas_key; 
	} 
	public void setVentas_key(java.lang.String ventas_key) { 
	  this.ventas_key = ventas_key; 
	} 
	public java.lang.String getFecemision() { 
	  return fecemision; 
	} 
	public void setFecemision(java.lang.String fecemision) { 
	  this.fecemision = fecemision; 
	} 
	public java.lang.String getEmp_descri() { 
	  return emp_descri; 
	} 
	public void setEmp_descri(java.lang.String emp_descri) { 
	  this.emp_descri = emp_descri; 
	} 
	public java.lang.String getEmp_siglas() { 
	  return emp_siglas; 
	} 
	public void setEmp_siglas(java.lang.String emp_siglas) { 
	  this.emp_siglas = emp_siglas; 
	} 
	public java.lang.String getEmp_direc() { 
	  return emp_direc; 
	} 
	public void setEmp_direc(java.lang.String emp_direc) { 
	  this.emp_direc = emp_direc; 
	} 
	public java.lang.String getEmp_ruc() { 
	  return emp_ruc; 
	} 
	public void setEmp_ruc(java.lang.String emp_ruc) { 
	  this.emp_ruc = emp_ruc; 
	} 
	public java.lang.String getEmp_telef() { 
	  return emp_telef; 
	} 
	public void setEmp_telef(java.lang.String emp_telef) { 
	  this.emp_telef = emp_telef; 
	} 
	public java.lang.String getEmp_email() { 
	  return emp_email; 
	} 
	public void setEmp_email(java.lang.String emp_email) { 
	  this.emp_email = emp_email; 
	} 
	public java.lang.String getEmp_web() { 
	  return emp_web; 
	} 
	public void setEmp_web(java.lang.String emp_web) { 
	  this.emp_web = emp_web; 
	} 
	public java.lang.String getCod_hash() { 
	  return cod_hash; 
	} 
	public void setCod_hash(java.lang.String cod_hash) { 
	  this.cod_hash = cod_hash; 
	} 
	public java.lang.String getDocformato() { 
	  return docformato; 
	} 
	public void setDocformato(java.lang.String docformato) { 
	  this.docformato = docformato; 
	} 
	public java.lang.String getDocnombre() { 
	  return docnombre; 
	} 
	public void setDocnombre(java.lang.String docnombre) { 
	  this.docnombre = docnombre; 
	} 
	public java.lang.String getPdf147() { 
	  return pdf147; 
	} 
	public void setPdf147(java.lang.String pdf147) { 
	  this.pdf147 = pdf147; 
	} 
	public java.lang.String getCondvta_id() { 
	  return condvta_id; 
	} 
	public void setCondvta_id(java.lang.String condvta_id) { 
	  this.condvta_id = condvta_id; 
	} 
	public java.lang.String getCondvta_des() { 
	  return condvta_des; 
	} 
	public void setCondvta_des(java.lang.String condvta_des) { 
	  this.condvta_des = condvta_des; 
	} 
	public java.lang.String getVend_id() { 
	  return vend_id; 
	} 
	public void setVend_id(java.lang.String vend_id) { 
	  this.vend_id = vend_id; 
	} 
	public java.lang.String getVend_des() { 
	  return vend_des; 
	} 
	public void setVend_des(java.lang.String vend_des) { 
	  this.vend_des = vend_des; 
	} 
	public java.lang.String getLis_id() { 
	  return lis_id; 
	} 
	public void setLis_id(java.lang.String lis_id) { 
	  this.lis_id = lis_id; 
	} 
	public java.lang.String getLis_des() { 
	  return lis_des; 
	} 
	public void setLis_des(java.lang.String lis_des) { 
	  this.lis_des = lis_des; 
	} 
	public java.lang.String getClie_id() { 
	  return clie_id; 
	} 
	public void setClie_id(java.lang.String clie_id) { 
	  this.clie_id = clie_id; 
	} 
	public java.lang.String getClie_des() { 
	  return clie_des; 
	} 
	public void setClie_des(java.lang.String clie_des) { 
	  this.clie_des = clie_des; 
	} 
	public java.lang.String getDir_ent() { 
	  return dir_ent; 
	} 
	public void setDir_ent(java.lang.String dir_ent) { 
	  this.dir_ent = dir_ent; 
	} 
	public java.lang.String getPedido() { 
	  return pedido; 
	} 
	public void setPedido(java.lang.String pedido) { 
	  this.pedido = pedido; 
	} 
	public java.lang.String getNroguia() { 
	  return nroguia; 
	} 
	public void setNroguia(java.lang.String nroguia) { 
	  this.nroguia = nroguia; 
	} 
	public java.lang.String getR_leyenda_monto_letras() { 
	  return r_leyenda_monto_letras; 
	} 
	public void setR_leyenda_monto_letras(java.lang.String r_leyenda_monto_letras) { 
	  this.r_leyenda_monto_letras = r_leyenda_monto_letras; 
	} 
	public java.lang.String getFecentrega() { 
	  return fecentrega; 
	} 
	public void setFecentrega(java.lang.String fecentrega) { 
	  this.fecentrega = fecentrega; 
	} 
	public java.lang.String getZona_id() { 
	  return zona_id; 
	} 
	public void setZona_id(java.lang.String zona_id) { 
	  this.zona_id = zona_id; 
	} 
	public java.math.BigDecimal getTotperc() { 
	  return totperc; 
	} 
	public void setTotperc(java.math.BigDecimal totperc) { 
	  this.totperc = totperc; 
	} 
	public java.lang.String getZona_des() { 
	  return zona_des; 
	} 
	public void setZona_des(java.lang.String zona_des) { 
	  this.zona_des = zona_des; 
	} 
	public java.lang.String getTrans_id() { 
	  return trans_id; 
	} 
	public void setTrans_id(java.lang.String trans_id) { 
	  this.trans_id = trans_id; 
	} 
	public java.lang.String getTrans_des() { 
	  return trans_des; 
	} 
	public void setTrans_des(java.lang.String trans_des) { 
	  this.trans_des = trans_des; 
	} 
	public java.lang.String getTrans_placa() { 
	  return trans_placa; 
	} 
	public void setTrans_placa(java.lang.String trans_placa) { 
	  this.trans_placa = trans_placa; 
	} 
	public java.lang.String getTrans_ruc() { 
	  return trans_ruc; 
	} 
	public void setTrans_ruc(java.lang.String trans_ruc) { 
	  this.trans_ruc = trans_ruc; 
	} 
	public java.lang.String getTrans_marca() { 
	  return trans_marca; 
	} 
	public void setTrans_marca(java.lang.String trans_marca) { 
	  this.trans_marca = trans_marca; 
	} 
	public java.lang.String getTrans_licencia() { 
	  return trans_licencia; 
	} 
	public void setTrans_licencia(java.lang.String trans_licencia) { 
	  this.trans_licencia = trans_licencia; 
	} 
	public java.lang.String getChofer() { 
	  return chofer; 
	} 
	public void setChofer(java.lang.String chofer) { 
	  this.chofer = chofer; 
	} 
	public java.lang.String getMoneda() { 
	  return moneda; 
	} 
	public void setMoneda(java.lang.String moneda) { 
	  this.moneda = moneda; 
	} 
	public java.math.BigDecimal getTipocambio() { 
	  return tipocambio; 
	} 
	public void setTipocambio(java.math.BigDecimal tipocambio) { 
	  this.tipocambio = tipocambio; 
	} 
	public java.lang.String getRuc() { 
	  return ruc; 
	} 
	public void setRuc(java.lang.String ruc) { 
	  this.ruc = ruc; 
	} 
	public java.lang.String getRucdni() { 
	  return rucdni; 
	} 
	public void setRucdni(java.lang.String rucdni) { 
	  this.rucdni = rucdni; 
	} 
	public java.lang.String getDocidentidad() { 
	  return docidentidad; 
	} 
	public void setDocidentidad(java.lang.String docidentidad) { 
	  this.docidentidad = docidentidad; 
	} 
	public java.lang.String getDocumentokey() { 
	  return documentokey; 
	} 
	public void setDocumentokey(java.lang.String documentokey) { 
	  this.documentokey = documentokey; 
	} 
	public java.lang.String getEmp_id() { 
	  return emp_id; 
	} 
	public void setEmp_id(java.lang.String emp_id) { 
	  this.emp_id = emp_id; 
	} 
	public java.lang.String getPeriodo() { 
	  return periodo; 
	} 
	public void setPeriodo(java.lang.String periodo) { 
	  this.periodo = periodo; 
	} 
	public java.lang.String getCorreo() { 
	  return correo; 
	} 
	public void setCorreo(java.lang.String correo) { 
	  this.correo = correo; 
	} 
	public java.lang.String getArt_id() { 
	  return art_id; 
	} 
	public void setArt_id(java.lang.String art_id) { 
	  this.art_id = art_id; 
	} 
	public java.lang.String getArt_des() { 
	  return art_des; 
	} 
	public void setArt_des(java.lang.String art_des) { 
	  this.art_des = art_des; 
	} 
	public java.lang.String getTipafec() { 
	  return tipafec; 
	} 
	public void setTipafec(java.lang.String tipafec) { 
	  this.tipafec = tipafec; 
	} 
	public java.lang.String getArt_unimedsun() { 
	  return art_unimedsun; 
	} 
	public void setArt_unimedsun(java.lang.String art_unimedsun) { 
	  this.art_unimedsun = art_unimedsun; 
	} 
	public java.lang.String getTipitem() { 
	  return tipitem; 
	} 
	public void setTipitem(java.lang.String tipitem) { 
	  this.tipitem = tipitem; 
	} 
	public java.lang.String getOp_grava() { 
	  return op_grava; 
	} 
	public void setOp_grava(java.lang.String op_grava) { 
	  this.op_grava = op_grava; 
	} 
	public java.lang.String getOp_gratuitas() { 
	  return op_gratuitas; 
	} 
	public void setOp_gratuitas(java.lang.String op_gratuitas) { 
	  this.op_gratuitas = op_gratuitas; 
	} 
	public java.lang.String getOp_exone() { 
	  return op_exone; 
	} 
	public void setOp_exone(java.lang.String op_exone) { 
	  this.op_exone = op_exone; 
	} 
	public java.lang.String getOp_inafe() { 
	  return op_inafe; 
	} 
	public void setOp_inafe(java.lang.String op_inafe) { 
	  this.op_inafe = op_inafe; 
	} 
	public java.lang.String getDesc_total() { 
	  return desc_total; 
	} 
	public void setDesc_total(java.lang.String desc_total) { 
	  this.desc_total = desc_total; 
	} 
	public java.lang.String getIgv_total() { 
	  return igv_total; 
	} 
	public void setIgv_total(java.lang.String igv_total) { 
	  this.igv_total = igv_total; 
	} 
	public java.lang.String getIsc_total() { 
	  return isc_total; 
	} 
	public void setIsc_total(java.lang.String isc_total) { 
	  this.isc_total = isc_total; 
	} 
	public java.lang.String getTotal_pagar() { 
	  return total_pagar; 
	} 
	public void setTotal_pagar(java.lang.String total_pagar) { 
	  this.total_pagar = total_pagar; 
	} 
	public java.math.BigDecimal getCantped() { 
	  return cantped; 
	} 
	public void setCantped(java.math.BigDecimal cantped) { 
	  this.cantped = cantped; 
	} 
	public java.math.BigDecimal getPreunit() { 
	  return preunit; 
	} 
	public void setPreunit(java.math.BigDecimal preunit) { 
	  this.preunit = preunit; 
	} 
	public java.math.BigDecimal getValventa() { 
	  return valventa; 
	} 
	public void setValventa(java.math.BigDecimal valventa) { 
	  this.valventa = valventa; 
	} 
	public java.math.BigDecimal getPordesc() { 
	  return pordesc; 
	} 
	public void setPordesc(java.math.BigDecimal pordesc) { 
	  this.pordesc = pordesc; 
	} 
	public java.math.BigDecimal getTotdesc() { 
	  return totdesc; 
	} 
	public void setTotdesc(java.math.BigDecimal totdesc) { 
	  this.totdesc = totdesc; 
	} 
	public java.math.BigDecimal getValafec() { 
	  return valafec; 
	} 
	public void setValafec(java.math.BigDecimal valafec) { 
	  this.valafec = valafec; 
	} 
	public java.math.BigDecimal getPorimp() { 
	  return porimp; 
	} 
	public void setPorimp(java.math.BigDecimal porimp) { 
	  this.porimp = porimp; 
	} 
	public java.math.BigDecimal getValimp() { 
	  return valimp; 
	} 
	public void setValimp(java.math.BigDecimal valimp) { 
	  this.valimp = valimp; 
	} 
	public java.math.BigDecimal getValperc() { 
	  return valperc; 
	} 
	public void setValperc(java.math.BigDecimal valperc) { 
	  this.valperc = valperc; 
	} 
	public java.math.BigDecimal getPreventa() { 
	  return preventa; 
	} 
	public void setPreventa(java.math.BigDecimal preventa) { 
	  this.preventa = preventa; 
	} 
	public java.math.BigDecimal getPreventaperc() { 
	  return preventaperc; 
	} 
	public void setPreventaperc(java.math.BigDecimal preventaperc) { 
	  this.preventaperc = preventaperc; 
	} 
	public java.lang.String getUrl_web() { 
	  return url_web; 
	} 
	public void setUrl_web(java.lang.String url_web) { 
	  this.url_web = url_web; 
	} 
	public java.lang.String getTipooperacion() { 
	  return tipooperacion; 
	} 
	public void setTipooperacion(java.lang.String tipooperacion) { 
	  this.tipooperacion = tipooperacion; 
	} 
	public java.lang.String getCodigo_qr() { 
	  return codigo_qr; 
	} 
	public void setCodigo_qr(java.lang.String codigo_qr) { 
	  this.codigo_qr = codigo_qr; 
	} 
	public java.lang.String getPesototal() { 
	  return pesototal; 
	} 
	public void setPesototal(java.lang.String pesototal) { 
	  this.pesototal = pesototal; 
	} 
	public java.lang.String getUnidadpeso() { 
	  return unidadpeso; 
	} 
	public void setUnidadpeso(java.lang.String unidadpeso) { 
	  this.unidadpeso = unidadpeso; 
	}

    public String getRuta_logo() {
        return ruta_logo;
    }

    public void setRuta_logo(String ruta_logo) {
        this.ruta_logo = ruta_logo;
    }

    public String getRuta_qr() {
        return ruta_qr;
    }

    public void setRuta_qr(String ruta_qr) {
        this.ruta_qr = ruta_qr;
    }
}
