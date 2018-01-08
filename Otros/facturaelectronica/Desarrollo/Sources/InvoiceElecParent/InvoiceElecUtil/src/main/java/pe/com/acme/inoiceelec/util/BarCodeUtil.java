package pe.com.acme.inoiceelec.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;

@Component
public class BarCodeUtil {

	@Value("${ruta.bar.code}")
	private String RUTA_BAR_CODE;
	@Value("${ruta.bar.codematrix}")
	private String RUTA_BAR_CODEMATRIX;

	public String generateBarCode(String value, String name) throws IOException, WriterException {

		this.createFolder(RUTA_BAR_CODE);
		
		int sizeWidth = 400;
		int sizeHeight = 150;
		String fileType = "png";
		
		
		BitMatrix bitMatrix;
		
		String fileCodeBar = RUTA_BAR_CODE + "/" + name + ".png";
		
		File myFile = new File(fileCodeBar);
		
		Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		
		// Now with zxing version 3.2.1 you could change border size (white border size to just 1)
		hintMap.put(EncodeHintType.MARGIN, 4); /* default = 4 */
		hintMap.put(EncodeHintType.ERROR_CORRECTION, 5);


		bitMatrix = new Code128Writer().encode(value, BarcodeFormat.CODE_128, sizeWidth, sizeHeight, hintMap);
		
		BufferedImage image = new BufferedImage(sizeWidth, sizeHeight,BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, sizeWidth, sizeHeight);
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < sizeWidth; i++) {
			for (int j = 0; j < sizeHeight; j++) {
				if (bitMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		
		ImageIO.write(image, fileType, myFile);
		
		return fileCodeBar;
	}

	public String generateBarCodeMatrix(String value, String name) throws WriterException, FileNotFoundException, IOException {

		this.createFolder(RUTA_BAR_CODEMATRIX);
		
		int sizeWidth = 400;
		int sizeHeight = 150;
		String fileType = "png";
		
		
		BitMatrix bitMatrix;
		Writer writer = new QRCodeWriter();

		String fileCodeBar = RUTA_BAR_CODEMATRIX + "/" + name + ".png";
		
		Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		
		// Now with zxing version 3.2.1 you could change border size (white border size to just 1)
		hintMap.put(EncodeHintType.MARGIN, 4); /* default = 4 */
		hintMap.put(EncodeHintType.ERROR_CORRECTION, 5);
		
		// Write PDF417
		writer = new PDF417Writer();
		bitMatrix = writer.encode(value, BarcodeFormat.PDF_417, sizeWidth, sizeHeight,hintMap);
		MatrixToImageWriter.writeToStream(bitMatrix, fileType, new FileOutputStream(new File(fileCodeBar)));
		
		return fileCodeBar;
	}
	public void createFolder(String path){
		File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
	}
}
