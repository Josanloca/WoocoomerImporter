package Model;

import java.util.List;

public class Producto {
	
	private int Id;
	private String Nombre;
	private String Descripcion;
	private double Precio;
	private String Categoria;
	private String Imgurl;
	private String Talla;
	private String Color;
	private String Variable;
	private String ImgRuta;
	private float Peso;
	private float Longitud;
	private float Anchura;
	private float Altura;
	private List <Producto> ProductosVariables;
	
	public Producto() {
	}

	public Producto(int id, String nombre, String descripcion, double precio, String categoria, String imgurl,
			String talla, String color, String variable, String imgRuta, float peso, float longitud, float anchura,
			float altura) {
		super();
		Id = id;
		Nombre = nombre;
		Descripcion = descripcion;
		Precio = precio;
		Categoria = categoria;
		Imgurl = imgurl;
		Talla = talla;
		Color = color;
		Variable = variable;
		ImgRuta = imgRuta;
		Peso = peso;
		Longitud = longitud;
		Anchura = anchura;
		Altura = altura;
		ProductosVariables = null;
	}
	
	public Producto(int id, String nombre, String descripcion, double precio, String categoria,
			String talla, String color, String variable, float peso, float longitud, float anchura,
			float altura) {
		super();
		Id = id;
		Nombre = nombre;
		Descripcion = descripcion;
		Precio = precio;
		Categoria = categoria;
		Talla = talla;
		Color = color;
		Variable = variable;
		Peso = peso;
		Longitud = longitud;
		Anchura = anchura;
		Altura = altura;
		ProductosVariables = null;
	}
	public Producto(List <Producto> productosvariables) {
		ProductosVariables = productosvariables;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public String getImgurl() {
		return Imgurl;
	}
	public void setImgurl(String imgurl) {
		Imgurl = imgurl;
	}
	public String getTalla() {
		return Talla;
	}
	public void setTalla(String talla) {
		Talla = talla;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getVariable() {
		return Variable;
	}
	public void setVariable(String variable) {
		Variable = variable;
	}
	public String getImgRuta() {
		return ImgRuta;
	}
	public void setImgRuta(String imgRuta) {
		ImgRuta = imgRuta;
	}
	public float getPeso() {
		return Peso;
	}
	public void setPeso(short peso) {
		Peso = peso;
	}
	public float getLongitud() {
		return Longitud;
	}
	public void setLongitud(short longitud) {
		Longitud = longitud;
	}
	public float getAnchura() {
		return Anchura;
	}
	public void setAnchura(short anchura) {
		Anchura = anchura;
	}
	public float getAltura() {
		return Altura;
	}
	public void setAltura(short altura) {
		Altura = altura;
	}
	public List <Producto> getProductosVariables() {
		return ProductosVariables;
	}
	public void setProductosVariables(List <Producto> productosVariables) {
		ProductosVariables = productosVariables;
	}

	@Override
	public String toString() {
		return "Producto [Id=" + Id + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Precio=" + Precio
				+ ", Categoria=" + Categoria + ", Imgurl=" + Imgurl + ", Talla=" + Talla + ", Color=" + Color
				+ ", Variable=" + Variable + ", ImgRuta=" + ImgRuta + ", Peso=" + Peso + ", Longitud=" + Longitud
				+ ", Anchura=" + Anchura + ", Altura=" + Altura + ", ProductosVariables=" + ProductosVariables + "]";
	}
	
}
