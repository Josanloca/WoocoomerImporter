package Model;

public class Talla {
	
	private byte Id;
	private String Nombre;
	
	
	public Talla() {
	}
	
	public Talla(String nombre) {
		super();
		Nombre = nombre;
	}
	
	public Talla(byte id, String nombre) {
		super();
		Id = id;
		Nombre = nombre;
	}
	
	
	
	public byte getId() {
		return Id;
	}
	public void setId(byte id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	@Override
	public String toString() {
		return "Talla [Id=" + Id + ", Nombre=" + Nombre + "]";
	}	

}
