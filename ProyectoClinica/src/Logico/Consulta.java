package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Consulta {
<<<<<<< HEAD

=======
	
	private String NombreDoc;
>>>>>>> branch 'master' of https://github.com/CarlosDavidHC/ProyectoFinalClinica.git
	private Paciente paciente;
<<<<<<< HEAD
	private ArrayList<Enfermedad> enfermedad;
	private ArrayList<HistorialClinico> histoClinica;
=======
	private Arraylist<Enfermedad> enfermedad;
	private HistorialClinico histoClinico;
>>>>>>> branch 'master' of https://github.com/CarlosDavidHC/ProyectoFinalClinica.git
	private Date fecha;
<<<<<<< HEAD

	public Consulta(Paciente paciente, ArrayList<Enfermedad> enfermedad, ArrayList<HistorialClinico> histoClinica,
			Date fecha) {
=======
	public Consulta(String nombreDoc, Paciente paciente, Arraylist<Enfermedad> enfermedad,
			HistorialClinico histoClinico, Date fecha) {
		super();
		NombreDoc = nombreDoc;
>>>>>>> branch 'master' of https://github.com/CarlosDavidHC/ProyectoFinalClinica.git
		this.paciente = paciente;
		this.enfermedad = enfermedad;
<<<<<<< HEAD
		this.histoClinica = new ArrayList<>();
=======
		this.histoClinico = histoClinico;
>>>>>>> branch 'master' of https://github.com/CarlosDavidHC/ProyectoFinalClinica.git
		this.fecha = fecha;
	}
<<<<<<< HEAD

=======
	public String getNombreDoc() {
		return NombreDoc;
	}
	public void setNombreDoc(String nombreDoc) {
		NombreDoc = nombreDoc;
	}
>>>>>>> branch 'master' of https://github.com/CarlosDavidHC/ProyectoFinalClinica.git
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
<<<<<<< HEAD

	public ArrayList<HistorialClinico> getHistoClinica() {
		return histoClinica;
=======
	public HistorialClinico getHistoClinico() {
		return histoClinico;
>>>>>>> branch 'master' of https://github.com/CarlosDavidHC/ProyectoFinalClinica.git
	}
<<<<<<< HEAD

	public void setHistoClinica(ArrayList<HistorialClinico> histoClinica) {
		this.histoClinica = histoClinica;
=======
	public void setHistoClinico(HistorialClinico histoClinico) {
		this.histoClinico = histoClinico;
>>>>>>> branch 'master' of https://github.com/CarlosDavidHC/ProyectoFinalClinica.git
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
<<<<<<< HEAD

=======
	
	
	
>>>>>>> branch 'master' of https://github.com/CarlosDavidHC/ProyectoFinalClinica.git
}
