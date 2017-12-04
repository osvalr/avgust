package pe.com.acme.util;

/**
 * Created by JRaffo on 9/10/15.
 */
public abstract class AbstractModel {

	/*Inicio - Campos de Audotoria*/
	protected String fecha_registro;
	protected Integer id_usuario_reg;
	protected Integer id_usuario_mod;
	protected String fecha_modificacion;
	/*Fin - Campos de Audotoria*/
	
	protected Integer rownum;
	protected boolean newEntry = false;
    protected boolean updatedRecord = false;
    protected boolean removedRecord = false;

    public boolean isNewEntry() {
        return newEntry;
    }
    public void setNewEntry(boolean newEntry) {
        this.newEntry = newEntry;
    }

    public boolean isUpdatedRecord() {
        return updatedRecord;
    }

    public void setUpdatedRecord(boolean updatedRecord) {
        this.updatedRecord = updatedRecord;
    }

    public boolean isRemovedRecord() {
        return removedRecord;
    }

    public void setRemovedRecord(boolean removedRecord) {
        this.removedRecord = removedRecord;
    }

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Integer getId_usuario_reg() {
		return id_usuario_reg;
	}

	public void setId_usuario_reg(Integer id_usuario_reg) {
		this.id_usuario_reg = id_usuario_reg;
	}

	public String getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public Integer getId_usuario_mod() {
		return id_usuario_mod;
	}

	public void setId_usuario_mod(Integer id_usuario_mod) {
		this.id_usuario_mod = id_usuario_mod;
	}
	public Integer getRownum() {
		return rownum;
	}
	public void setRownum(Integer rownum) {
		this.rownum = rownum;
	}
	    
}
