package pe.com.focus.sakerk.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.focus.repository.mybatis.mapper.ArchivoMapper;
import pe.com.focus.repository.mybatis.model.Archivo;
import pe.com.focus.repository.mybatis.model.ArchivoKey;
import pe.com.focus.sakerk.business.service.CommonService;

@Controller
@RequestMapping("/")
public class DownloadImageControlller {
	
	@Autowired
	private CommonService commonService;
	
	public static final int IMG_WIDTH = 145;
	public static final int IMG_HEIGHT = 165;
	
	@RequestMapping(value="downloadImageBase64.action")
	public @ResponseBody String downloadImageBase64(Integer id_archivo){
		
		ArchivoKey archivoKey = new ArchivoKey();
		archivoKey.setId_archivo(id_archivo);
		Archivo archivo = commonService.selectByPrimaryKey(ArchivoMapper.class, archivoKey);
		String base64StringFoto = null;
		try {
			base64StringFoto = encodeFileToBase64Binary(archivo.getRuta_archivo(),archivo.getNombre_archivo());
		} catch (IOException e) {
			e.printStackTrace();
		}
		base64StringFoto = "data:image/png;base64,"+base64StringFoto;
		return base64StringFoto;
		
	}
	
	private String encodeFileToBase64Binary(String pathFile,String fileName) throws IOException {
		
		String path = pathFile.replace(fileName, "");
		String nameWhitoutExtension = fileName.substring(0,fileName.indexOf("."));
		String pathImageResize = path+nameWhitoutExtension+"_"+IMG_WIDTH+"_"+IMG_HEIGHT+".png";
		
		File imageRisize = new File(pathImageResize);
		
		if(!imageRisize.exists()){
//			BufferedImage originalImage = ImageIO.read(new File(pathFile));
//			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
//			
//			BufferedImage resizeImageJpg = resizeImageWithHint(originalImage, type);
//			ImageIO.write(resizeImageJpg, "png", new File(pathImageResize));
			
			BufferedImage img = ImageIO.read(new File(pathFile));
			   
			BufferedImage scaledImg = Scalr.resize(img, Mode.FIT_EXACT, IMG_WIDTH, IMG_HEIGHT);
			   
			File destFile = new File(pathImageResize);
			   
			ImageIO.write(scaledImg, "png", destFile);
			
		}
		
		File file = new File(pathImageResize);
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.encodeBase64(bytes);
		String encodedString = new String(encoded);
 
		return encodedString;
	}
	
	@SuppressWarnings("resource")
	private static byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);
 
	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];
	    
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }
 
	    if (offset < bytes.length) {
	        throw new IOException("No se puede leer el archivo "+file.getName());
	    }
 
	    is.close();
	    return bytes;
	}
//    private BufferedImage resizeImage(BufferedImage originalImage, int type){
//		
//    	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
//		Graphics2D g = resizedImage.createGraphics();
//		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
//		g.dispose();
// 
//		return resizedImage;
//    }
 
//    private BufferedImage resizeImageWithHint(BufferedImage originalImage, int type){
// 
//		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
//		Graphics2D g = resizedImage.createGraphics();
//		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
//		g.dispose();	
//		g.setComposite(AlphaComposite.Src);
//	 
//		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//		RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//		g.setRenderingHint(RenderingHints.KEY_RENDERING,
//		RenderingHints.VALUE_RENDER_QUALITY);
//		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//		RenderingHints.VALUE_ANTIALIAS_ON);
// 
//		return resizedImage;
//    }	
}
