package pe.com.jrtotem.app.generator.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fxmisc.richtext.StyleSpans;
import org.fxmisc.richtext.StyleSpansBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import pe.com.jrtotem.app.generator.dto.DataTypeDto;

public class ConstanUtil {

	public static List<DataTypeDto> DATA_TYPES = null;
	private static ObjectMapper mapper = null;
	
	static{
		mapper = new ObjectMapper();
		String json = null;
		try {
			json = new String(Files.readAllBytes(Paths.get("misc/datatype.json")));
			DATA_TYPES = mapper.readValue(json, new TypeReference<List<DataTypeDto>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 String keyword = PropUtil.getInstance().getPropVal("keywords.properties", "keywords_sql");
		 keyword = keyword + "," + keyword.toUpperCase();
		 KEYWORDS = keyword.split(",");
		 
		 String ignoreColumns = PropUtil.getInstance().getPropVal("ignoreColumns.properties", "ignore");
		 IGNORE_COLUMNS = ignoreColumns.split(",");
	}
	
	//Tipos de Datos
	public static final String INTEGER = "integer";
	public static final String DOUBLE = "double";
	public static final String STRING = "string";
	public static final String BYTE = "byte";
	public static final String DATE = "date";
	public static final String BIG_INTEGER = "bigInteger";
	public static final String BIG_DECIMAL = "bigDecimal";
		
	//Db tipo de Datos
	public static final int DB_INTEGER = 4;
	public static final int DB_SMALLINT = 5;
	public static final int DB_TINYINT = -6;
	public static final int DB_DOUBLE = 8;
	public static final int DB_DECIMAL = 3;
	public static final int DB_FLOAT = 6;
	public static final int DB_NUMERIC = 2;
	public static final int DB_VARCHAR = 12;
	public static final int DB_BYTE = -2;
	public static final int DB_DATE = 91;	
	public static final int DB_TIME = 92;
	public static final int DB_TIMESTAMP = 93;
	public static final int DB_NULL = 0;
	public static final int DB_BIG_INTEGER = -5;
	
	//Tipo Ingreso / Salida
	public static final String OUT = "out";
	public static final String INPUT = "input";
	
	//Engine Db
	public static final int MYSQL = 1;
	public static final int POSTGRES = 2;
	public static final int ORACLE = 3;
	public static final int MSSQL = 4;
	public static final int SQLITE = 5;
	
	//Driver class jdbc
	public static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
	public static final String DRIVER_CLASS_POSTGRES = "org.postgresql.Driver";
	public static final String DRIVER_CLASS_ORACLE = "oracle.jdbc.driver.OracleDriver";
	public static final String DRIVER_CLASS_MSSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DRIVER_CLASS_SQLITE = "org.sqlite.JDBC";
	
	//url connecction
	public static final String URL_CONNECTION_MYSQL = "jdbc:mysql://localhost:3306/dbname";
	public static final String URL_CONNECTION_POSTGRES = "jdbc:postgresql://localhost:5432/dbname";
	public static final String URL_CONNECTION_ORACLE = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String URL_CONNECTION_MSSQL = "jdbc:sqlserver://localhost:1433;DatabaseName=dbname";
	public static final String URL_CONNECTION_SQLITE = "jdbc:sqlite:database.db";
	
	//query test
	public static final String QUERY_TEST = "select 1 as val;";
	public static final String QUERY_TEST_ORACLE = "select 1 val from dual";
	
	public static final int ESTADO_ACTIVO = 1;
	public static final int ESTADO_INACTIVO = 2;
	
	public static String[] IGNORE_COLUMNS;
	
	public static String[] KEYWORDS;
	
	public static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    public static final String PAREN_PATTERN = "\\(|\\)";
    public static final String BRACE_PATTERN = "\\{|\\}";
    public static final String BRACKET_PATTERN = "\\[|\\]";
    public static final String SEMICOLON_PATTERN = "\\;";
    public static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    public static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";

    public static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
            + "|(?<PAREN>" + PAREN_PATTERN + ")"
            + "|(?<BRACE>" + BRACE_PATTERN + ")"
            + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
            + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
            + "|(?<STRING>" + STRING_PATTERN + ")"
            + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );
    
    public static StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while(matcher.find()) {
            String styleClass =
                    matcher.group("KEYWORD") != null ? "keyword" :
                    matcher.group("PAREN") != null ? "paren" :
                    matcher.group("BRACE") != null ? "brace" :
                    matcher.group("BRACKET") != null ? "bracket" :
                    matcher.group("SEMICOLON") != null ? "semicolon" :
                    matcher.group("STRING") != null ? "string" :
                    matcher.group("COMMENT") != null ? "comment" :
                    null; /* never happens */ assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }
    	
	public static String getDateString(){
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		return reportDate;
		
	}
	
	public static void showExceptionDialog(Exception ex){
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Dialog");
		alert.setHeaderText("Look, an Exception Dialog");
		alert.setContentText(ex.getMessage());

		// Create expandable Exception.
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String exceptionText = sw.toString();

		Label label = new Label("The exception stacktrace was:");

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}
	
	public static DataTypeDto findByNameDataType(String nameDataType){
		for(DataTypeDto dataTypeDto : DATA_TYPES){
			if(dataTypeDto.getNameDataType().equals(nameDataType)){
				return dataTypeDto;
			}
		}
		return null;
	}
}
