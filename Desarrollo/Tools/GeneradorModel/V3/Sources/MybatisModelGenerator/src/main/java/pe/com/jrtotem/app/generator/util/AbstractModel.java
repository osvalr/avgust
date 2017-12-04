package pe.com.jrtotem.app.generator.util;

import java.util.Date;

/**
 * Created by JRaffo on 9/10/15.
 */
public abstract class AbstractModel {

	/*Inicio - Campos de Audotoria*/
	protected Integer id_estado;
	protected Date fecha_registro;
	protected Integer id_usuario_reg;
	protected Date fecha_modificacion;
	/*Fin - Campos de Audotoria*/
	
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

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Integer getId_usuario_reg() {
		return id_usuario_reg;
	}

	public void setId_usuario_reg(Integer id_usuario_reg) {
		this.id_usuario_reg = id_usuario_reg;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
    
}
