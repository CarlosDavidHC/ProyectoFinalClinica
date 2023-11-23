package Logico;

public class Vacuna {

	private String nombre;
	private Paciente paciente;
	private ArrayList<Enfermedad> enfermedad;
	
	public Vacuna(String nombre, Paciente paciente, ArrayList<Enfermedad> enfermedad) {
		super();
		this.nombre = nombre;
		this.paciente = paciente;
		this.enfermedad = enfermedad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
	
	
}
