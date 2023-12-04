package Logico;

public class Paciente extends Persona {

	private HistorialClinico historial;

	public Paciente(String codigo, String cedula, String nombre, String telefono, String direccion, char tipo,
			char sexo, HistorialClinico historial) {
		super(codigo, cedula, nombre, telefono, direccion, tipo, sexo);
		this.historial = historial;
	}

	public HistorialClinico getHistorial() {
		return historial;
	}

	public void setHistorial(HistorialClinico historial) {
		this.historial = historial;
	}

	public void agregarCitaAlHistorial(Cita cita) {
		this.historial.getMisCitas().add(cita);
	}

}
