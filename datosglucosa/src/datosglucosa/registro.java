package datosglucosa;


public class registro {

		private String nombre;
		private double glucosa; 
		
		public registro() {}
			public registro(String nombre, double glucosa) {
				this.nombre= nombre;
				this.glucosa= glucosa;
				
			 
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

