package Logico;

public class Consulta {
	
	private Paciente paciente;
	private Arraylist<Enfermedad> enfermedad;
	private HistoriaClinica histoClinica;
	
	public Consulta(Paciente paciente, Arraylist<Enfermedad> enfermedad, HistoriaClinica histoClinica) {
		super();
		this.paciente = paciente;
		this.enfermedad = enfermedad;
		this.histoClinica = histoClinica;
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
	

}
