package Logico;

public class Consulta {
	
	private Paciente paciente;
	private Arraylist<Enfermedad> enfermedad;
	private HistoriaClinica histoClinica;
	private Date fecha;
	public Consulta(Paciente paciente, Arraylist<Enfermedad> enfermedad, HistoriaClinica histoClinica, Date fecha) {
		super();
		this.paciente = paciente;
		this.enfermedad = enfermedad;
		this.histoClinica = histoClinica;
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
	public HistoriaClinica getHistoClinica() {
		return histoClinica;
	}
	public void setHistoClinica(HistoriaClinica histoClinica) {
		this.histoClinica = histoClinica;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
