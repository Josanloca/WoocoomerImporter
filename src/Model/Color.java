package Model;

public class Color {
	
	private byte Id;
	private String Nombre;
	
	public Color(String nombre) {
		super();
		Nombre = nombre;
	}

	public Color(byte id, String nombre) {
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
		return "Color [Id=" + Id + ", Nombre=" + Nombre + "]";
	}
}
