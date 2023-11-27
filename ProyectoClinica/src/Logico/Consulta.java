package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Consulta {

	private Paciente paciente;
	private ArrayList<Enfermedad> enfermedad;
	private ArrayList<HistorialClinico> histoClinica;
	private Date fecha;

	public Consulta(Paciente paciente, ArrayList<Enfermedad> enfermedad, ArrayList<HistorialClinico> histoClinica,
			Date fecha) {
		this.paciente = paciente;
		this.enfermedad = enfermedad;
		this.histoClinica = new ArrayList<>();
		this.fecha = fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ArrayList<Enfermedad> getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(ArrayList<Enfermedad> enfermedad) {
		this.enfermedad = enfermedad;
	}

	public ArrayList<HistorialClinico> getHistoClinica() {
		return histoClinica;
	}

	public void setHistoClinica(ArrayList<HistorialClinico> histoClinica) {
		this.histoClinica = histoClinica;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
