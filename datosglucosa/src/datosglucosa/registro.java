package datosglucosa;
import java.time.LocalDate;

public class registro {

	private String nombre;
	private double glucosa; 
	private LocalDate fecha;
	public registro() {}
		public registro(String nombre, double glucosa, LocalDate fecha) {
			this.nombre= nombre;
			this.glucosa= glucosa;
			this.fecha= fecha;
		 
		
		}
		public String toString() {
			return nombre + " |" + fecha+" | glucosa"+ glucosa+" gm/Ld";
		}

		public LocalDate getFecha() {
			return fecha;
		}
		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double getGlucosa() {
			return glucosa;
		}

		public void setGlucosa(double glucosa) {
			this.glucosa = glucosa;
		}


}
