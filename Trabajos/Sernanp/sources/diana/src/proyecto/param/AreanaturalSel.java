package proyecto.param;

import proyecto.vo.Areanatural;

public class AreanaturalSel implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idareanaturalsel;
	private Areanatural areanatural;
	private int flagseleccion;
	
	public AreanaturalSel(){
		areanatural=new Areanatural();
	}

	public Areanatural getAreanatural() {
		return areanatural;
	}

	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}

	public int getFlagseleccion() {
		return flagseleccion;
	}

	public void setFlagseleccion(int flagseleccion) {
		this.flagseleccion = flagseleccion;
	}

	public int getIdareanaturalsel() {
		return idareanaturalsel;
	}

	public void setIdareanaturalsel(int idareanaturalsel) {
		this.idareanaturalsel = idareanaturalsel;
	}

	
	
	
}
