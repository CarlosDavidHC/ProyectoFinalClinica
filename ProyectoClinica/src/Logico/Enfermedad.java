package Logico;

public class Enfermedad {

	private String CodigoEnfermedad;
	private String Nombre;
	private String Descripcion;
	
	public Enfermedad(String codigoEnfermedad, String nombre, String descripcion) {
		super();
		CodigoEnfermedad = codigoEnfermedad;
		Nombre = nombre;
		Descripcion = descripcion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getCodigoEnfermedad() {
		return CodigoEnfermedad;
	}

	public void setCodigoEnfermedad(String codigoEnfermedad) {
		CodigoEnfermedad = codigoEnfermedad;
	}
}
