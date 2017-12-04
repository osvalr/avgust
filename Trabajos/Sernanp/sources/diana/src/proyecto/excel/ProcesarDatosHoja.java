package proyecto.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.opensymphony.xwork2.ActionSupport;

import proyecto.service.PersonalRegistroService;
import proyecto.service.TipoService;
import proyecto.vo.PersonalRegistro;
import proyecto.vo.Personanatural;
import proyecto.vo.Tipo;

public class ProcesarDatosHoja extends ManipularLibros {
    
	/**
     * 
     * @param strArchivoIn
     * @param intIndice
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws FormatoUsuariosException 
     */
	
	public List<PersonalRegistro> cargarDatos(String strArchivoIn, int intIndice) throws FileNotFoundException,
            IOException, FormatoUsuariosException {


        Iterator<Row> row = tomarRegistros(strArchivoIn, intIndice);
                
        PersonalRegistro c = null;

        List<PersonalRegistro> lista = new ArrayList<PersonalRegistro>();
        
        
        
        row.next();
        while (row.hasNext()) {

            Row r = row.next();

            Iterator<Cell> celda = r.cellIterator();
            
            c = new PersonalRegistro();

            while (celda.hasNext()) {

                Cell cel = celda.next();

                if (cel.getColumnIndex() == 0) {
                	cel.setCellType(Cell.CELL_TYPE_STRING);
                	
                    if (cel.getCellType() != 3) {
                    	//if(cel.getCellType() == 0)cel.setCellType(Cell.CELL_TYPE_STRING);
                        c.setNombre(cel.toString().trim());
                    } else {
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 1) {
                	cel.setCellType(Cell.CELL_TYPE_STRING);
                	
                    if (cel.getCellType() != 3) {
                    	//if(cel.getCellType() == 0)cel.setCellType(Cell.CELL_TYPE_STRING);
                        c.setApepat(cel.toString().trim());
                        
                    } else {
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 2) {
                	cel.setCellType(Cell.CELL_TYPE_STRING);
                	
                    if (cel.getCellType() != 3) {
                    	//if(cel.getCellType() == 0)cel.setCellType(Cell.CELL_TYPE_STRING);
                        c.setApemat(cel.toString().trim());
                    } else {
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 3) {
                	cel.setCellType(Cell.CELL_TYPE_STRING);
                	
                    if (cel.getCellType() != 3) {
                    	//if(cel.getCellType() == 0)cel.setCellType(Cell.CELL_TYPE_STRING);
                        c.setEmpresa(cel.toString().trim());
                    } else {
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 4) {
                	//cel.setCellType(Cell.CELL_TYPE_NUMERIC);
                	
                    if (cel.getCellType() != 3 && cel.getCellType() == 0) {
                    	//if(cel.getCellType() == 0)cel.setCellType(Cell.CELL_TYPE_STRING);
                    	cel.setCellType(Cell.CELL_TYPE_STRING);
                    	Tipo td = new Tipo(1);
                    	td.setIdtipo(Integer.valueOf(cel.toString()));
                    	
                        c.setTipodocumento(td);
                    } else {                    	
                    	
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 5) {
                	//cel.setCellType(Cell.CELL_TYPE_NUMERIC);
                	cel.setCellType(Cell.CELL_TYPE_STRING);
                    if (cel.getCellType() != 3) {
                    	if(c.getTipodocumento().getIdtipo() == 1 && cel.toString().trim().length() != 8){
                    		establecerException(cel);
                    	}else{
                    		c.setNumerodocumento(cel.toString().trim());
                    	}
                    } else {
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 6) {                	
                	//cel.setCellType(Cell.CELL_TYPE_NUMERIC);
                    if (cel.getCellType() != 3  && cel.getCellType() == 0) {
                    	cel.setCellType(Cell.CELL_TYPE_STRING);
                    	
                    	Tipo tl = new Tipo(22);
                    	tl.setIdtipo(Integer.valueOf(cel.toString().trim()));
                    	
                    	c.setTipolocal(tl);
                    } else {
                        establecerException(cel);
                    }
                }
                if (cel.getColumnIndex() == 7) {
                	
                    if (cel.getCellType() != 3 && cel.getCellType() == 0) {
                    	cel.setCellType(Cell.CELL_TYPE_STRING);
                    	
                    	Tipo ts = new Tipo(2);
                    	ts.setIdtipo(Integer.valueOf(cel.toString().trim()));
                        c.setSexo(ts);                      
                    } else {
                        establecerException(cel);
                    }
                }
               
                
            }           
            
            c.setIdestado(1);
            
            lista.add(c);
        }
        return lista;
    }

    /**
     * 
     * @param strArchivoIn
     * @param intIndice
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Iterator<Row> tomarRegistros(String strArchivoIn, int intIndice) throws FileNotFoundException,
            IOException {
        
    	cargarArchivo(strArchivoIn);

        HSSFSheet hoja = obtenerHoja(intIndice);

        Iterator<Row> row = hoja.rowIterator();
        return row;

    }

    public void establecerException(Cell cel) throws FormatoUsuariosException {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("La celda [").append(cel.getRowIndex()).append(",").append(cel.getColumnIndex());
        builder.append("] tiene un valor incorrecto [");
        builder.append(cel.toString()).append("]");
        throw new FormatoUsuariosException(builder.toString());
    }

	
    
    
}
