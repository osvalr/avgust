package proyecto.constants;

import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;

public class  FontsPDF {
    /** A font used in our PDF file */
    public static final Font TITLE = new Font(FontFamily.HELVETICA, 16, Font.BOLD);  
    /** A font used in our PDF file */
    public static final Font NORMAL = new Font(FontFamily.HELVETICA, 10, Font.NORMAL);
    /** A font used in our PDF file */
    public static final Font BOLD = new Font(FontFamily.HELVETICA, 10, Font.BOLD);
    /** A font used in our PDF file */
    public static final Font ITALIC = new Font(FontFamily.HELVETICA, 10, Font.ITALIC);
    /** A font used in our PDF file */      
    public static final Font BOLDITALIC = new Font(FontFamily.HELVETICA, 10, Font.BOLDITALIC);
    /** A font used in our PDF file */
    public static final Font TABLECELL = new Font(FontFamily.HELVETICA, 8, Font.NORMAL);   
    /** A font used in our Table Headers */  
    public static final Font TABLEHEADERCELL = new Font(FontFamily.HELVETICA, 8, Font.BOLD);
}
