public class Producto {
String id;
String nombre;
String serie;
String valor;
String proveedor;
String existencias;
Producto(String id, String nombre, String serie, String valor, String proveedor, String existencias){this.id = id;
    this.nombre = nombre;
    this.serie = serie;
    this.valor = valor;
    this.proveedor = proveedor;
    this.existencias = existencias;}

    public String returnNombre (){return this.nombre;}
    public String returnId (){return this.id;}
    public String returnSerie (){return this.serie;}
    public String returnValor (){return this.valor;}
    public String returnProveedor (){return this.proveedor;}
    public String returnExistencias (){return this.existencias;}
}

