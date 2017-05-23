
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsFactura;
import java.util.ArrayList;


public class clsReportes {
    
   
    //listado de todos los clientes con compras mayores a 100
    //mostrar la no factura, fecha, total y el nombre del cliente 
    
    public static ArrayList<clsFactura> clienteFacturaMayorMil() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT " +
                    "  factura.id_cliente, " +
                    "  factura.id_factura, " +
                    "  factura.fecha, " +
                    "  factura.total, " +
                    "  cliente.ruc, " +
                    "  cliente.id_cliente" +
                    "FROM " +
                    "  public.cliente, INNER JOIN" +
                    "  public.factura" +
                    "ON" +
                    "  cliente.id = factura.\"id_cliente\"" +
                    "ORDER BY " +
                    "  cliente.nombre ASC;";
        

        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next())
            {
                factura = new clsFactura();
                //todo: programar getclienteid y comprobar el sql(falta comilla de las tabla)
                factura.setId_factura(cres.getInt("id_factura"));
                //factura.setCliente(cres.getClientebyId(""));
                 factura.setFecha(cres.getDate("fecha"));
                factura.setTotal(cres.getDouble("total"));
                
               
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
    
    //1.-MOSTRR LA SUMA COMPRAS POR CADA CLIENTE
    
    public static ArrayList<clsFactura> sumaCompraPorCliente() { 
    ArrayList<clsFactura> listado = new ArrayList<>(); 
    String sql = "SELECT " 
            + "Count(\"public\".factura.\"no\") AS \"Total\", " 
            + "\"public\".cliente.nombre," 
            + "\"public\".cliente.ruc " 
            + "FROM" 
            + "\"public\".cliente" 
            + "INNER JOIN \"public\".factura ON \"public\".factura.id_cliente = \"public\".cliente.\"id_cliente\"" 
            + "GROUP BY" 
            + "public\".cliente.nombre" 
            + "\"public\".cliente.ruc"; 

    ArrayList<Parametro> lstPar = new ArrayList<>(); 
    try { 
    ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar); 
    clsFactura factura = null; 
    while (cres.next()) 
    { factura = new clsFactura(); 
        factura.setId_factura(cres.getInt("id_factura")); 
        //factura.setId_cliente(crudCliente.findbyId(cres.getInt("id_cliente"))); 
        listado.add((factura)); } } 
        catch (Exception e) { 
        System.out.println(e.getMessage()); 
        } 
    return listado;
    }
    
    //2.- NUMERO DE COMPRAS QUE HIZO EL CLIENTE 
    
    public static ArrayList<clsFactura> numeroCompraCliente() { 
    ArrayList<clsFactura> listado = new ArrayList<>(); 
    String sql = "SELECT " 
        + "\"public\".cliente.nombre, " 
        + "Count(\"public\".factura.\"id_factura\") AS \"Numero de compras\" " 
        + "FROM " 
        + "\"public\".cliente, INNER JOIN" 
        + "\"public\".factura" 
        + "ON" 
        + "\"public\".factura.clienteid = \"public\".cliente.\"id_cliente\"" 
        + "GROUP BY" 
        + "\"public\".cliente.nombre"; 
    ArrayList<Parametro> lstPar = new ArrayList<>(); 
    try { 
    ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar); 
    clsFactura factura = null; 
    while (cres.next()) { 
        factura = new clsFactura(); 
        factura.setId_factura(cres.getInt("no")); 
        //factura.setId_cliente(crudCliente.findbyId(cres.getInt("id_cliente"))); 
        
        listado.add((factura)); 
    } 
    } catch (Exception e) { 
    System.out.println(e.getMessage()); 
    } 
    return listado; 
} 
   
    //NUMERO DE COMPRAS Y TOTAL 
    public static ArrayList<clsFactura> numeroComprasTotal() { 
    ArrayList<clsFactura> listado = new ArrayList<>(); 
    String sql = "SELECT " 
            + "Count(\"public\".factura.\"no\") AS NUMERO_COMPRAS " 
            + "sum(\"public\".factura.total) AS total" 
            + "FROM " 
            + "\"public\".factura"; 
    ArrayList<Parametro> lstPar = new ArrayList<>(); 
    try { 
    ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar); 
    clsFactura factura = null; 
    while (cres.next()) { 
    factura = new clsFactura(); 
    factura.setId_factura(cres.getInt("no")); 
    factura.setTotal(cres.getInt("total")); 
    listado.add((factura)); 
    } 
    } catch (Exception e) { 
    System.out.println(e.getMessage()); 
    } 
    return listado; 
} 

    //6.- EL PROMEDIO DE COMPRAS 
    public static ArrayList<clsFactura> promedioCompra() { 
        ArrayList<clsFactura> listado = new ArrayList<>(); 
        String sql = "SELECT " 
                    + "AVG(\"public\".factura.total) as Promedio " 
                    + "FROM " 
                    + "\"public\".factura"; 
        ArrayList<Parametro> lstPar = new ArrayList<>(); 
        try { 
        ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar); 
        clsFactura factura = null; 
        while (cres.next()) { 
        factura = new clsFactura(); 
        factura.setTotal(cres.getInt("total")); 
        listado.add((factura)); 
        } 
        } catch (Exception e) { 
    System.out.println(e.getMessage()); 
    } 
    return listado; 
    }

}
