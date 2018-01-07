package pe.com.kapcom.facturador.ws.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import pe.com.kapcom.facturador.ws.model.extra.DocumentoVenta;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaAgrupadoQuery;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaAgrupadoQueryCriteria;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaDetalleQuery;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaDetalleQueryCriteria;
import pe.com.kapcom.facturador.ws.service.api.ReportCommonService;
import pe.com.kapcom.facturador.ws.util.ReportHelper;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.*;

@RestController
@RequestMapping("/api/v1.0/report")
public class ReportCommonRestController extends ReportHelper {

    private static Logger log = Logger.getLogger(ReportCommonRestController.class);

    @Autowired
    private ReportCommonService reportCommonService;

    @CrossOrigin
    @RequestMapping(value = "/documento-venta-detalle/{doc_type}", method = RequestMethod.GET)
    public void reporteDocumentoVentaDetalle(@PathVariable("doc_type") String doc_type, DocumentoVentaDetalleQueryCriteria criteria, HttpServletResponse response) {

        try {

            String jasper_tipo=null;
            JasperPrint jasperPrint=null;

            List<DocumentoVentaDetalleQuery> list = reportCommonService.obtenerDetalleDocumentos(criteria);

            Map<String, Object> params = new HashMap<>();

            if (doc_type.contentEquals("pdf")) {
                jasper_tipo = "documento_venta.jasper";
            }

            jasperPrint = this.getJasperPrint("/report/common/" + jasper_tipo, params, list);
            String mime = ReportHelper.mapContepType.get(doc_type);
            String fileName = "doc_"+criteria.getNumero_doc_inicio()+"_"+criteria.getNumero_doc_final() +"." + doc_type;

            this.setResponseInfo(response, mime, fileName);

            final OutputStream outStream = response.getOutputStream();

            JRAbstractExporter exporter = this.getExporter(doc_type, jasperPrint, outStream, fileName);

            exporter.exportReport();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/documento-venta/{doc_type}", method = RequestMethod.GET)
    public void reporteDocumentoVenta(@PathVariable("doc_type") String doc_type, DocumentoVentaAgrupadoQueryCriteria criteria, HttpServletResponse response) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            String jasper_tipo=null;
            JasperPrint jasperPrint=null;

            List<DocumentoVentaAgrupadoQuery> list = reportCommonService.obtenerDocumentos(criteria);
            List<DocumentoVenta> listDoc = new ArrayList<>();

            for(DocumentoVentaAgrupadoQuery x : list){

                List<Map<String, Object>> mapList = new ArrayList<>();
                for(DocumentoVentaDetalleQuery q : x.getListDocumentoVentaDetalleQuery()){
                    Map<String, Object> map = mapper.convertValue(q,Map.class);
                    mapList.add(map);
                }

                DocumentoVenta documentoVenta = new DocumentoVenta();
                documentoVenta.setVentas_key(x.getVentas_key());
                documentoVenta.setVentasDetalle_1(castListToJRMaCollectionDataSource(mapList));
                documentoVenta.setVentasDetalle_2(castListToJRMaCollectionDataSource(mapList));
                listDoc.add(documentoVenta);
            }

            ClassPathResource cpr = new ClassPathResource("/report/common/documento_venta.jasper");

            Map<String, Object> params = new HashMap<>();
            params.put("pathSubReport",cpr.getPath());

            if (doc_type.contentEquals("pdf")) {
                jasper_tipo = "documento_venta_final.jasper";
            }

            jasperPrint = this.getJasperPrint("/report/common/" + jasper_tipo, params, listDoc);
            String mime = ReportHelper.mapContepType.get(doc_type);
            String fileName = "doc_"+criteria.getNumero_doc_inicio()+"_"+criteria.getNumero_doc_final() +"." + doc_type;

            this.setResponseInfo(response, mime, fileName);

            final OutputStream outStream = response.getOutputStream();

            JRAbstractExporter exporter = this.getExporter(doc_type, jasperPrint, outStream, fileName);

            exporter.exportReport();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
    public JRMapCollectionDataSource castListToJRMaCollectionDataSource(List<?> listDetalle) {
        JRMapCollectionDataSource listMapDetalle = new JRMapCollectionDataSource((Collection) listDetalle);
        return listMapDetalle;
    }
}
