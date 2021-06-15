package Logic;
	import Model.Categ;
import Model.Color;
import Model.Producto;
import Model.Talla;

import java.io.FileOutputStream;
	import java.io.IOException;

	import org.w3c.dom.DOMImplementation;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.Node;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.*;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.transform.stream.StreamResult;
	import javax.xml.xpath.XPath;
	import javax.xml.xpath.XPathConstants;
	import javax.xml.xpath.XPathExpressionException;
	import javax.xml.xpath.XPathFactory;

import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.List;
	
public class XmlTransformer {

	    private static Document docGET;
	    private static Document docXML;
	    
	    private static Document docGETatribut;
	    private static Document docXMLatribut;

		public static String XMLtallas [];
		public static String XMLcolores [];
		public static String XMLcategorias [];
		
		public static final String RUTAGUARDADO = new JFileChooser().getFileSystemView().getDefaultDirectory().toString()+"/ArchivoGuardado.xml";
		public static final String ATRIBUT = new JFileChooser().getFileSystemView().getDefaultDirectory().toString()+"/ArchivoAtributos.xml";
				
	    public XmlTransformer(){
	    }

	    public static void guardadorEnXML(List<Producto> lista) {
	        creadorPrimarioXML();
	        addXML(lista);
	        guardar(RUTAGUARDADO);
	    }

	    private static void guardar(String file_name_xml) {
	        try{
	            Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
	            transformer.setOutputProperty(OutputKeys.METHOD,"xml");
	            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
	            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	            transformer.transform(new DOMSource(docGET),new StreamResult(new FileOutputStream(file_name_xml)));
	        } catch (TransformerConfigurationException | FileNotFoundException e) {
	            System.out.println("ERROR EN EL GUARDADO");
	        } catch (TransformerException e) {
	            System.out.println("ERROR EN EL GUARDADO");
	        }
	    }

	    public static void creadorPrimarioXML(){
	        String sNombre = "Lista_Producto";
	        DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        try{
	            dBuilder = documentBuilderFactory.newDocumentBuilder();
	            DOMImplementation implementation = dBuilder.getDOMImplementation();
	            docGET = implementation.createDocument(null,sNombre,null);
	        }catch (ParserConfigurationException e){
	            System.out.println("Error en la conversion");
	        }
	    }

	    private static void addXML(List<Producto> lista) {
	    	List<Producto> lProducto= null;
	    	
	    	Node IdProducto =null;
	        Node Id = null;
	        Node Nombre = null;
	        Node Descripcion = null;
	        Node Precio = null;
	        Node Categoria = null;
	        Node Imgurl = null;
	        Node Talla = null;
	        Node Color = null;
	        Node Variable = null;
	        
	        Node Variables = null;
	        Node variacion = null;
	        
	        Node VId = null;
	        Node VNombre = null;
	        Node VDescripcion = null;
	        Node VPrecio = null;
	        Node VCategoria = null;
	        Node VImgurl = null;
	        Node VTalla = null;
	        Node VColor = null;
	        Node VVariable = null;	        
	        Node VImgRuta = null;
	        Node VPeso = null;
	        Node VLongitud = null;
	        Node VAnchura = null;
	        Node VAltura = null;
	        
	        Node ImgRuta = null;
	        Node Peso = null;
	        Node Longitud = null;
	        Node Anchura = null;
	        Node Altura = null;

	        lProducto  = lista;
	        
	        for (Producto interior : lProducto){
	        	List<Producto> lVariableMulti=null;	
	        		        	
	        	IdProducto = docGET.createElement("Producto");
	        	
	        	Id = docGET.createElement("Id");
	        	Id.appendChild(docGET.createTextNode(String.valueOf(interior.getId())) );

	        	Nombre = docGET.createElement("Nombre");
	        	Nombre.appendChild(docGET.createTextNode(String.valueOf(interior.getNombre())) );

	        	Descripcion = docGET.createElement("Descripcion");
	        	Descripcion.appendChild(docGET.createTextNode(String.valueOf(interior.getDescripcion())));

	        	Precio = docGET.createElement("Precio");
	        	Precio.appendChild(docGET.createTextNode(String.valueOf(interior.getPrecio())));

	        	Categoria = docGET.createElement("Categoria");
	        	Categoria.appendChild(docGET.createTextNode(String.valueOf(interior.getCategoria())));

	        	Imgurl = docGET.createElement("Imgurl");	        	
	        	Imgurl.appendChild(docGET.createTextNode(String.valueOf(interior.getImgurl())));
	            
	        	Talla = docGET.createElement("Talla");
	        	Talla.appendChild(docGET.createTextNode(interior.getTalla()));
	            
	        	Color = docGET.createElement("Color");
	        	Color.appendChild(docGET.createTextNode(interior.getColor()));
	        	
	        	Variable = docGET.createElement("Variable");
	        	Variable.appendChild(docGET.createTextNode(interior.getVariable()));
	        	
	        	ImgRuta = docGET.createElement("ImgRuta");
	        	ImgRuta.appendChild(docGET.createTextNode(interior.getImgRuta()));
	        	
	        	Peso = docGET.createElement("Peso");
	        	Peso.appendChild(docGET.createTextNode(String.valueOf(interior.getPeso())));
	        	
	        	Longitud = docGET.createElement("Longitud");
	        	Longitud.appendChild(docGET.createTextNode(String.valueOf(interior.getLongitud())));
	        	
	        	Anchura = docGET.createElement("Anchura");
	        	Anchura.appendChild(docGET.createTextNode(String.valueOf(interior.getAnchura())));
	        	
	        	Altura = docGET.createElement("Altura");
	        	Altura.appendChild(docGET.createTextNode(String.valueOf(interior.getAltura())));
	            
	        	IdProducto.appendChild(Id);
	        	IdProducto.appendChild(Nombre);
	        	IdProducto.appendChild(Descripcion);
	        	IdProducto.appendChild(Precio);
	        	IdProducto.appendChild(Categoria);
	        	IdProducto.appendChild(Imgurl);
	        	IdProducto.appendChild(Talla);
	        	IdProducto.appendChild(Color);
	        	IdProducto.appendChild(Variable);
	            
	        	if((interior.getVariable().equals("variable"))) {
	        		
	        		lVariableMulti = interior.getProductosVariables();
	        		
	        		Variables = docGET.createElement("Multiples-Variables");
	        		
	        		IdProducto.appendChild(Variables);
	        		
	        		for (Producto PVari : lVariableMulti){
	        			
	        			variacion = docGET.createElement("Variacion");
	        			
	    	        	VId = docGET.createElement("VId");
	    	        	VId.appendChild(docGET.createTextNode(String.valueOf(PVari.getId())) );

	    	        	VNombre = docGET.createElement("VNombre");
	    	        	VNombre.appendChild(docGET.createTextNode(String.valueOf(PVari.getNombre())) );

	    	        	VDescripcion = docGET.createElement("VDescripcion");
	    	        	VDescripcion.appendChild(docGET.createTextNode(String.valueOf(PVari.getDescripcion())));

	    	        	VPrecio = docGET.createElement("VPrecio");
	    	        	VPrecio.appendChild(docGET.createTextNode(String.valueOf(PVari.getPrecio())));

	    	        	VCategoria = docGET.createElement("VCategoria");
	    	        	VCategoria.appendChild(docGET.createTextNode(String.valueOf(PVari.getCategoria())));

	    	        	VImgurl = docGET.createElement("VImgurl");
	    	        	if(PVari.getImgurl()==null) {
	    	        		VImgurl.appendChild(docGET.createTextNode(String.valueOf("")));
	    	        	}else {
		    	        	VImgurl.appendChild(docGET.createTextNode(String.valueOf(PVari.getImgurl())));
	    	        	}
	    	            
	    	        	VTalla = docGET.createElement("VTalla");
	    	        	VTalla.appendChild(docGET.createTextNode(PVari.getTalla()));
	    	            
	    	        	VColor = docGET.createElement("VColor");
	    	        	VColor.appendChild(docGET.createTextNode(PVari.getColor()));
	    	        	
	    	        	VVariable = docGET.createElement("VVariable");
	    	        	VVariable.appendChild(docGET.createTextNode(PVari.getVariable()));
	        			
	    	        	VImgRuta = docGET.createElement("VImgRuta");
	    	        	if(PVari.getImgurl()==null) {
	    	        		VImgRuta.appendChild(docGET.createTextNode(String.valueOf("")));
	    	        	}else {
		    	        	VImgRuta.appendChild(docGET.createTextNode(PVari.getImgRuta()));
	    	        	}
	    	        	
	    	        	VPeso = docGET.createElement("VPeso");
	    	        	VPeso.appendChild(docGET.createTextNode(String.valueOf(PVari.getPeso())));
	    	        	
	    	        	VLongitud = docGET.createElement("VLongitud");
	    	        	VLongitud.appendChild(docGET.createTextNode(String.valueOf(PVari.getLongitud())));
	    	        	
	    	        	VAnchura = docGET.createElement("VAnchura");
	    	        	VAnchura.appendChild(docGET.createTextNode(String.valueOf(PVari.getAnchura())));
	    	        	
	    	        	VAltura = docGET.createElement("VAltura");
	    	        	VAltura.appendChild(docGET.createTextNode(String.valueOf(PVari.getAltura())));
	    	        	
	    	        	variacion.appendChild(VId);
	    	        	variacion.appendChild(VNombre);
	    	        	variacion.appendChild(VDescripcion);
	    	        	variacion.appendChild(VPrecio);
	    	        	variacion.appendChild(VCategoria);
	    	        	variacion.appendChild(VImgurl);
	    	        	variacion.appendChild(VTalla);
	    	        	variacion.appendChild(VColor);
	    	        	variacion.appendChild(VVariable);
	    	        	variacion.appendChild(VImgRuta);
	    	        	variacion.appendChild(VPeso);
	    	        	variacion.appendChild(VLongitud);
	    	        	variacion.appendChild(VAnchura);
	    	        	variacion.appendChild(VAltura);
	    	        	
	    	        	Variables.appendChild(variacion);
	        		}
	    		}
	        	IdProducto.appendChild(ImgRuta);
	        	IdProducto.appendChild(Peso);
	        	IdProducto.appendChild(Longitud);
	        	IdProducto.appendChild(Anchura);
	        	IdProducto.appendChild(Altura);
	        	
	            docGET.getFirstChild().appendChild(IdProducto);
	        }
	    }
	        
	        public static void GETxml() {
	            try{
	                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

	                docXML = dBuilder.parse(RUTAGUARDADO);
	                docXML.getDocumentElement().normalize();

	            } catch (ParserConfigurationException | SAXException | IOException e) {
	                System.out.println("ERROR EN EL PRINCIPIO");
	            }
	        }

	        private static NodeList getNodeList(String expression){
	            NodeList nodeList = null;
	            XPath xPath = XPathFactory.newInstance().newXPath();

	            try{
	                nodeList = (NodeList) xPath.compile(expression).evaluate(docXML, XPathConstants.NODESET);

	            }catch (XPathExpressionException e) {
	                System.out.println("Error en get el nodoList +");
	            }
	            return nodeList;
	        }

	        public static List<Producto> theMEGAGET() {
	        	GETxml();
	        	
	            List<Producto> lProducto = new ArrayList<Producto>();
	            
	            Producto producto = null;

	            NodeList nodeList = getNodeList("Lista_Producto/Producto");
	            NodeList nodeListVariables = getNodeList("Lista_Producto/Producto/Multiples-Variables/Variacion");
	            
	            for(int i = 0; i < nodeList.getLength();i++){

	                Node nNode = nodeList.item(i);
	                
	                    Element eElement = (Element) nNode;
	                    
	                	int Id = Integer.parseInt(eElement.getElementsByTagName("Id").item(0).getTextContent());
	                	String Nombre = String.valueOf(eElement.getElementsByTagName("Nombre").item(0).getTextContent());
	                	String Descripcion = String.valueOf(eElement.getElementsByTagName("Descripcion").item(0).getTextContent());
	                	double Precio = Double.parseDouble(eElement.getElementsByTagName("Precio").item(0).getTextContent());
	                	String Categoria = String.valueOf(eElement.getElementsByTagName("Categoria").item(0).getTextContent());
	                	String Imgurl = String.valueOf(eElement.getElementsByTagName("Imgurl").item(0).getTextContent());
	                	String Talla = String.valueOf(eElement.getElementsByTagName("Talla").item(0).getTextContent());
	                	String Color = String.valueOf(eElement.getElementsByTagName("Color").item(0).getTextContent());
	                	String Variable = String.valueOf(eElement.getElementsByTagName("Variable").item(0).getTextContent());  
	                	String ImgRuta = String.valueOf(eElement.getElementsByTagName("ImgRuta").item(0).getTextContent());
	                	float Peso = Float.valueOf(eElement.getElementsByTagName("Peso").item(0).getTextContent());
	                	float Longitud = Float.valueOf(eElement.getElementsByTagName("Longitud").item(0).getTextContent());
	                	float Anchura = Float.valueOf(eElement.getElementsByTagName("Anchura").item(0).getTextContent());
	                	float Altura = Float.valueOf(eElement.getElementsByTagName("Altura").item(0).getTextContent());
	                	
	                	producto = new Producto( Id,	Nombre,  Descripcion,  Precio,  Categoria,  Imgurl,
    							Talla,  Color,Variable,ImgRuta,Peso,Longitud,Anchura,Altura);
	                		                	                
                    if(Variable.equals("variable")) {
        	            List<Producto> lVariables = new ArrayList<Producto>();
	                    
                    	for(int x = 0; x < nodeListVariables.getLength();x++){
                    		
        	                Node nNodeVariable = nodeListVariables.item(x);
        	                
    	                    Element eElementVariable = (Element) nNodeVariable;
                    		    	                    
                    		if((Id)==Integer.parseInt(eElementVariable.getElementsByTagName("VId").item(0).getTextContent())) {
                           		int vId = Integer.parseInt(eElementVariable.getElementsByTagName("VId").item(0).getTextContent());
    		                	String vNombre = String.valueOf(eElementVariable.getElementsByTagName("VNombre").item(0).getTextContent());
    		                	String vDescripcion = String.valueOf(eElementVariable.getElementsByTagName("VDescripcion").item(0).getTextContent());
    		                	double vPrecio = Double.parseDouble(eElementVariable.getElementsByTagName("VPrecio").item(0).getTextContent());
    		                	String vCategoria = String.valueOf(eElementVariable.getElementsByTagName("VCategoria").item(0).getTextContent());
    		                	String vImgurl = String.valueOf(eElementVariable.getElementsByTagName("VImgurl").item(0).getTextContent());
    		                	String vTalla = String.valueOf(eElementVariable.getElementsByTagName("VTalla").item(0).getTextContent());
    		                	String vColor = String.valueOf(eElementVariable.getElementsByTagName("VColor").item(0).getTextContent());
    		                	String vVariable = String.valueOf(eElementVariable.getElementsByTagName("VVariable").item(0).getTextContent());  
    		                	String vImgRuta = String.valueOf(eElementVariable.getElementsByTagName("VImgRuta").item(0).getTextContent());
    		                	float vPeso = Float.valueOf(eElementVariable.getElementsByTagName("VPeso").item(0).getTextContent());
    		                	float vLongitud = Float.valueOf(eElementVariable.getElementsByTagName("VLongitud").item(0).getTextContent());
    		                	float vAnchura = Float.valueOf(eElementVariable.getElementsByTagName("VAnchura").item(0).getTextContent());
    		                	float vAltura = Float.valueOf(eElementVariable.getElementsByTagName("VAltura").item(0).getTextContent());
    		                	
    		                	lVariables.add(new Producto(vId,	vNombre,  vDescripcion,  vPrecio,  vCategoria,  vImgurl,
        							vTalla,  vColor,vVariable,vImgRuta,vPeso,vLongitud,vAnchura,vAltura ));
                    		}
                    	}
                    	producto.setProductosVariables(lVariables);
	                    }
	                    lProducto.add(producto);
	            }
	                return lProducto;
	        }
	        
	        
		    public static void guardadorXMLAtributos() {
		    	CreadorInicioAtributos();
		    	addXMLAtribut();
		        guardarAtribut(ATRIBUT);
		    }
	        
		    
		    private static void guardarAtribut(String file_name_xml) {
		        try{
		        	Transformer transformer = TransformerFactory.newInstance().newTransformer();
		            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
		            transformer.setOutputProperty(OutputKeys.METHOD,"xml");
		            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
		            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		            transformer.transform(new DOMSource(docGETatribut),new StreamResult(new FileOutputStream(file_name_xml)));
		        } catch (TransformerConfigurationException | FileNotFoundException e) {
		        	System.out.println(e);
		            System.out.println("ERROR EN EL GUARDADO DE LOS ATRIBUTOS");
		        } catch (TransformerException e) {
		            System.out.println("ERROR EN EL GUARDADO de los atributos");
		        }
		    }
	        
	        
		    private static void CreadorInicioAtributos(){
		        String sNombre = "Lista_Atributos";
		        DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
		        DocumentBuilder dBuilder;
		        try{
		            dBuilder = documentBuilderFactory.newDocumentBuilder();
		            DOMImplementation implementation = dBuilder.getDOMImplementation();
		            docGETatribut = implementation.createDocument(null,sNombre,null);
		        }catch (ParserConfigurationException e){
		            System.out.println("Error en la conversion de atributos");
		        }
		    }

		    
		    @SuppressWarnings({ "unused" })
			private static void addXMLAtribut() {
		    	
		    	List<Talla> lTalla= null;
		    	List<Color> lColor= null;
		    	List<Categ> lCateg= null;
		    	
		    	Node ListTalla =null;
		    	Node ListColor = null;
		    	Node ListCateg = null;
		    	
		        Node Talla = null;
		        Node Color = null;
		        Node Categ = null;

		        ListTalla = docGETatribut.createElement("ListTalla");
		        
		        for (int i = 0; i < XMLtallas.length;i++){
		        	
		        	Talla = docGETatribut.createElement("Talla");
		        	Talla.appendChild(docGETatribut.createTextNode(String.valueOf(XMLtallas[i])));

		        	ListTalla.appendChild(Talla);
		        	
		        	docGETatribut.getFirstChild().appendChild(ListTalla);
		        }
		        
	        	ListColor = docGETatribut.createElement("ListColor");
		        
		        for (int i = 0; i < XMLcolores.length;i++){
		        	
		        	Color = docGETatribut.createElement("Color");
		        	Color.appendChild(docGETatribut.createTextNode(String.valueOf(XMLcolores[i])));

		        	ListColor.appendChild(Color);
		        	
		        	docGETatribut.getFirstChild().appendChild(ListColor);
		        }
		        
	        	ListCateg = docGETatribut.createElement("ListCateg");
		        
		        for (int i = 0; i < XMLcategorias.length;i++){
		        			        	
		        	Categ = docGETatribut.createElement("Categ");
		        	Categ.appendChild(docGETatribut.createTextNode(String.valueOf(XMLcategorias[i])));

		        	ListCateg.appendChild(Categ);
		        	
		        	docGETatribut.getFirstChild().appendChild(ListCateg);
		        }
		    }
	        
	        public static void GETxmlAtribut() {
	            try{
	                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	                docXMLatribut = dBuilder.parse(ATRIBUT);
	                docXMLatribut.getDocumentElement().normalize();

	            } catch (ParserConfigurationException | SAXException | IOException e) {
	                System.out.println("ERROR EN EL PRINCIPIO");
	            }
	        }
	        
	        private static NodeList getNodeListAtribut(String expression){
	            NodeList nodeList = null;
	            XPath xPath = XPathFactory.newInstance().newXPath();

	            try{
	                nodeList = (NodeList) xPath.compile(expression).evaluate(docXMLatribut, XPathConstants.NODESET);

	            }catch (XPathExpressionException e) {
	                System.out.println("Error en get el nodoList");
	            }
	            return nodeList;
	        }
	        
	        
	        public static void theGetAtribut() {
	        	GETxmlAtribut();
	        		            
	            NodeList nodeListTalla = getNodeListAtribut("Lista_Atributos/ListTalla/Talla");
	            XMLtallas= new String[nodeListTalla.getLength()];
	            
	            NodeList nodeListColor = getNodeListAtribut("Lista_Atributos/ListColor/Color");
	            XMLcolores = new String[nodeListColor.getLength()];
	            
	            NodeList nodeListCateg = getNodeListAtribut("Lista_Atributos/ListCateg/Categ");
	            XMLcategorias = new String[nodeListCateg.getLength()];
	            
	            for(int i = 0; i < nodeListTalla.getLength();i++){
	                Node nNode = nodeListTalla.item(i);
	                	                
	                	String TallaName = nNode.getTextContent();
	                	XMLtallas[i] = TallaName;
	            }
	            
	            for(int i = 0; i < nodeListColor.getLength();i++){
	                Node nNode = nodeListColor.item(i);
	                
	                	String ColorName = nNode.getTextContent();
	                	XMLcolores[i] = ColorName;
	            }
	            
	            for(int i = 0; i < nodeListCateg.getLength();i++){
	                Node nNode = nodeListCateg.item(i);
	                
	                	String CategName = nNode.getTextContent();
	                	XMLcategorias[i] = CategName;
	            }
	        }
	        

}
