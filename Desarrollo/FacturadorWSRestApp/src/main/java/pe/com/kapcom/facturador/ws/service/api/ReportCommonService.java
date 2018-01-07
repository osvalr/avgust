package pe.com.kapcom.facturador.ws.service.api;

import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaAgrupadoQuery;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaAgrupadoQueryCriteria;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaDetalleQuery;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaDetalleQueryCriteria;

import java.util.List;

public interface ReportCommonService {
    List<DocumentoVentaDetalleQuery> obtenerDetalleDocumentos(DocumentoVentaDetalleQueryCriteria criteria) throws Exception;
    List<DocumentoVentaAgrupadoQuery> obtenerDocumentos(DocumentoVentaAgrupadoQueryCriteria criteria) throws Exception;
}
