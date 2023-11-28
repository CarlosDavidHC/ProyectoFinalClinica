package Logico;

public class Paciente extends Persona {

	private HistorialClinico historial;
	

	public Paciente(String nombre, String codigo, String telefono, String direccion, char tipo, char sexo,
			HistorialClinico historial) {
		super(nombre, codigo, telefono, direccion, tipo, sexo);
		this.historial = historial;
	}
	

	public HistorialClinico getHistorial() {
		return historial;
	}

	public void setHistorial(HistorialClinico historial) {
		this.historial = historial;
	}

	
}
