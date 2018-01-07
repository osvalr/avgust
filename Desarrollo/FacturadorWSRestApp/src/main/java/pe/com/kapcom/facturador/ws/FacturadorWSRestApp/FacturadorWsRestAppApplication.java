package pe.com.kapcom.facturador.ws.FacturadorWSRestApp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan({"pe.com.kapcom.facturador.ws.rest.api","pe.com.kapcom.facturador.ws.service","pe.com.kapcom.util"})
@MapperScan("pe.com.kapcom.facturador.ws.model.mybatis.mapper")
public class FacturadorWsRestAppApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FacturadorWsRestAppApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FacturadorWsRestAppApplication.class, args);

//        {
//
//            String rutaQR = "/Users/JRaffo/GitHub/avgust/Desarrollo/FacturadorWSRestApp/images/qr/pruebaqr.png";
//
//            File f = new File(rutaQR);
//
//            int sizeWidth = 70;
//            int sizeHeight = 70;
//            BitMatrix bitMatrix;
////            Writer writer = new QRCodeWriter();
//
//            Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
//            hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//
//            // Now with zxing version 3.2.1 you could change border size (white border size to just 1)
//            hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
////            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
////            hintMap.put(EncodeHintType.PDF417_COMPACT, true);
//            hintMap.put(EncodeHintType.PDF417_COMPACTION, Compaction.NUMERIC);
//
//            // Write PDF417
//            Writer writer = new QRCodeWriter();
//            bitMatrix = writer.encode("Javier Raffo", BarcodeFormat.QR_CODE, sizeWidth, sizeHeight,hintMap);
//            MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File(rutaQR)));
//
//        }
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
