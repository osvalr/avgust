package pe.com.kapcom.facturador.ws.service.implement;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaAgrupadoQuery;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaAgrupadoQueryCriteria;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaDetalleQuery;
import pe.com.kapcom.facturador.ws.model.mybatis.bean.DocumentoVentaDetalleQueryCriteria;
import pe.com.kapcom.facturador.ws.model.mybatis.mapper.DocumentoVentaAgrupadoQueryMapper;
import pe.com.kapcom.facturador.ws.model.mybatis.mapper.DocumentoVentaDetalleQueryMapper;
import pe.com.kapcom.facturador.ws.service.api.ReportCommonService;

import java.io.File;
import java.io.FileOutputStream;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@PropertySource(value= {"classpath:files.properties"})
@Service
public class ReportCommonServiceImplement implements ReportCommonService {

    @Value("${ruta.logo.emp}")
    private String rutaLogo;

    @Value("${ruta.qr.documento}")
    private String rutaAlmacenQR;

    @Autowired
    private DocumentoVentaAgrupadoQueryMapper documentoVentaAgrupadoQueryMapper;
    @Autowired
    private DocumentoVentaDetalleQueryMapper documentoVentaDetalleQueryMapper;

    @Override
    public List<DocumentoVentaDetalleQuery> obtenerDetalleDocumentos(DocumentoVentaDetalleQueryCriteria criteria) throws Exception {

        List<DocumentoVentaDetalleQuery> list = documentoVentaDetalleQueryMapper.getListQueryByCriteria(criteria);

        for(DocumentoVentaDetalleQuery doc : list){

             doc.setRuta_logo(rutaLogo);

            String rutaQR = rutaAlmacenQR+doc.getDocformato()+".png";

            File f = new File(rutaQR);

            int sizeWidth = 70;
            int sizeHeight = 70;
            BitMatrix bitMatrix;

            Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            // Now with zxing version 3.2.1 you could change border size (white border size to just 1)
            hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
            hintMap.put(EncodeHintType.PDF417_COMPACT, true);
            hintMap.put(EncodeHintType.PDF417_COMPACTION, Compaction.BYTE);

            // Write PDF417
            Writer writer = new QRCodeWriter();
            bitMatrix = writer.encode(doc.getCodigo_qr(), BarcodeFormat.QR_CODE, sizeWidth, sizeHeight,hintMap);
            MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File(rutaQR)));

            doc.setRuta_qr(rutaQR);

        }
        return list;
    }

    @Override
    public List<DocumentoVentaAgrupadoQuery> obtenerDocumentos(DocumentoVentaAgrupadoQueryCriteria criteria) throws Exception {
        List<DocumentoVentaAgrupadoQuery> list = documentoVentaAgrupadoQueryMapper.getListQueryByCriteria(criteria);
        for(DocumentoVentaAgrupadoQuery doc : list){
            DocumentoVentaDetalleQueryCriteria c = new DocumentoVentaDetalleQueryCriteria();
            c.setNumero_doc_inicio(doc.getVentas_key());
            List<DocumentoVentaDetalleQuery> listDetalle = obtenerDetalleDocumentos(c);
            doc.setListDocumentoVentaDetalleQuery(listDetalle);
        }
        return list;
    }
}
