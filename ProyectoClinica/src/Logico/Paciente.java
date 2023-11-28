package Logico;

public class Paciente extends Persona {

	private HistorialClinico historial;
	

	public Paciente(String nombre, String cedula, String telefono, String direccion, HistorialClinico historial) {
		super(nombre, cedula, telefono, direccion);
		this.historial = historial;
	}

	public HistorialClinico getHistorial() {
		return historial;
	}

	public void setHistorial(HistorialClinico historial) {
		this.historial = historial;
	}

	
}
