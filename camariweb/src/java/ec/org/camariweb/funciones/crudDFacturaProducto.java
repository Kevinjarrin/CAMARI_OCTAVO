
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsDFacturaProducto;
import java.util.ArrayList;


public class crudDFacturaProducto {
    public static boolean save(clsDFacturaProducto dFacturaproducto){
        boolean resultado = false;
        
        String sql= "INSERT INTO public.detallefactura(id_factura, id_producto, cantidad, subtotal"
                + "estado VALUES(?,?,?,?)";
        
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, dFacturaproducto.getFactura().getId_factura()));
        lstPar.add(new Parametro(2, dFacturaproducto.getProducto().getId_producto()));
        lstPar.add(new Parametro(3, dFacturaproducto.getCantidad()));
        lstPar.add(new Parametro(4, dFacturaproducto.getSubtotal()));
         
               
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
        return resultado;
     }
    //ELMINAR
    public boolean delete(clsDFacturaProducto dFacturaproducto) {
        boolean res=false;
        String sql = "DELETE FROM public.detallefactura WHERE id=? ";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,dFacturaproducto.getId_dfacturaproducto()));
        
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }
    
   //ACTUALIZAR
    public boolean update(clsDFacturaProducto dFacturaproducto) {
        boolean res = false;
        String sql = "UPDATE public.detallefactura " +
                "SET factura=?,producto=?, cantidad=?, subtotal=?," + 
                "WHERE id_dfacturaproducto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1,dFacturaproducto.getFactura().getId_factura()));
        lstPar.add(new Parametro(2,dFacturaproducto.getProducto().getId_producto()));
        lstPar.add(new Parametro(3,dFacturaproducto.getCantidad()));
        lstPar.add(new Parametro(5,dFacturaproducto.getSubtotal()));

        
        
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
    
    
//SELECCIONAR
    public ArrayList<clsDFacturaProducto> findbyAll() {
        ArrayList<clsDFacturaProducto> listado = new ArrayList<>();
        String sql = "SELECT id_dfacturaproducto, id_factura, id_producto, cantidad, subtotal "+
                "FROM public.dFacturaProducto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsDFacturaProducto detallefactura = null;
            while (cres.next())
            {
                detallefactura = new clsDFacturaProducto();
                detallefactura.setId_dfacturaproducto(cres.getInt("id_dfacturaproducto"));
                detallefactura.setFactura(crudFactura.findbyId(cres.getInt("id_Factura")));
                detallefactura.setProducto(crudProducto.findbyId(cres.getInt("id_Producto")));
                detallefactura.setCantidad(cres.getInt("sctock"));
                detallefactura.setSubtotal(cres.getInt("subtotal"));
               
                listado.add((detallefactura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    
     public static clsDFacturaProducto findbyId(int id_dfacturaproducto) {
        clsDFacturaProducto DFacturaProducto = null;
        String sql = "SELECT id_dfacturaproducto, id_factura, id_producto, cantidad, subtotal "+
                "FROM public.dFacturaProducto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_dfacturaproducto));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                DFacturaProducto = new clsDFacturaProducto();
                DFacturaProducto.setId_dfacturaproducto(cres.getInt("id_dfacturaproducto"));
                DFacturaProducto.getFactura();
                DFacturaProducto.getFactura();
                DFacturaProducto.setCantidad(cres.getInt("cantidad"));
                DFacturaProducto.setSubtotal(cres.getInt("subtotal"));
                
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return DFacturaProducto;
    }

    public Object findbyId(clsDFacturaProducto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
