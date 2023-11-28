package Logico;

public class Doctor extends Persona {

	private String area;
	private String especialidad;

	public Doctor(String nombre, String codigo, String telefono, String direccion, char tipo, char sexo, String area,
			String especialidad) {
		super(nombre, codigo, telefono, direccion, tipo, sexo);
		this.area = area;
		this.especialidad = especialidad;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
