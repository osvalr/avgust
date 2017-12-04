package pe.com.acme.util;

public class MethodInfoUtil {
	
	private String nomMethod;
	private Class<?> typeDataMethod;
	private Object valueMethod;
	
	public String getNomMethod() {
		return nomMethod;
	}
	public void setNomMethod(String nomMethod) {
		this.nomMethod = nomMethod;
	}
	public Class<?> getTypeDataMethod() {
		return typeDataMethod;
	}
	public void setTypeDataMethod(Class<?> typeDataMethod) {
		this.typeDataMethod = typeDataMethod;
	}
	public Object getValueMethod() {
		return valueMethod;
	}
	public void setValueMethod(Object valueMethod) {
		this.valueMethod = valueMethod;
	}
	@Override
	public String toString() {
		return "MethodInfoUtil [nomMethod=" + nomMethod + ", typeDataMethod="
				+ typeDataMethod + ", valueMethod=" + valueMethod + "]";
	}
	
	
}

