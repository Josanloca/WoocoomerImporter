package Model;

public class Categ {
	
	private byte Id;
	private String Nombre;
	
	public Categ(String nombre) {
		super();
		Nombre = nombre;
	}
	
	public Categ(byte id, String nombre) {
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
		return "Categ [Id=" + Id + ", Nombre=" + Nombre + "]";
	}

}
