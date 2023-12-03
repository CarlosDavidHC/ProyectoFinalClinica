package Logico;

public abstract class Persona {

	protected String codigo;
	protected String nombre;
	protected String telefono;
	protected String direccion;
	protected char tipo; // p si es paciente ; d si es doctor.
	protected char sexo;

	public Persona(String nombre, String codigo, String telefono, String direccion, char tipo, char sexo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipo = tipo;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
