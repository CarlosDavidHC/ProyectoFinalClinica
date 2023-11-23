package Logico;

public class Consulta {
	
	private Paciente paciente;
	private Arraylist<Enfermedad> enfermedad;
	private HistorialClinico histoClinico;
	private Date fecha;
	public Consulta(Paciente paciente, Arraylist<Enfermedad> enfermedad, HistorialClinico histoClinico, Date fecha) {
		super();
		this.paciente = paciente;
		this.enfermedad = enfermedad;
		this.histoClinico = histoClinico;
		this.fecha = fecha;
	}
	
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Arraylist<Enfermedad> getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(Arraylist<Enfermedad> enfermedad) {
		this.enfermedad = enfermedad;
	}
	public HistorialClinico getHistoClinico() {
		return histoClinico;
	}
	public void setHistoClinico(HistorialClinico histoClinico) {
		this.histoClinico = histoClinico;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
