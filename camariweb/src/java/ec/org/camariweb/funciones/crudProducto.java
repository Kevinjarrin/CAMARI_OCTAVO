
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsProducto;
import java.util.ArrayList;

public class crudProducto {

    public static boolean save(clsProducto producto) {

        boolean resultado = false;

        String sql = "INSERT INTO producto(nombre, stock, precio_venta)"
                + " VALUES (?,?,?)";

        ArrayList<Parametro> lstPar = new ArrayList<>();

        lstPar.add(new Parametro(1, producto.getNombre()));
        lstPar.add(new Parametro(2, producto.getStock()));
        lstPar.add(new Parametro(3, producto.getPrecio_venta()));

        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;

    }

   
    
    public boolean delete(clsProducto miproducto) {
        boolean res=false;
        String sql = "DELETE FROM public.producto WHERE id_producto=? ";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,miproducto.getId_producto()));
        
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }
    //
    public boolean update(clsProducto producto) {
        boolean res = false;
        String sql = "UPDATE public.producto "
                + "SET nombre=?, stock=?, precio_venta= ? "
                + "WHERE id_producto = ?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getNombre()));
        lstPar.add(new Parametro(2, producto.getStock()));
        lstPar.add(new Parametro(3, producto.getPrecio_venta()));
        lstPar.add(new Parametro(4, producto.getId_producto()));

        try {
            res = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public ArrayList<clsProducto> findbyAll() {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT id_producto, nombre, stock, precio_venta "
                + "FROM public.producto";
        // Parametros vacios
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto producto = null;
            while (cres.next()) {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getInt("stock"));
                producto.setPrecio_venta(cres.getInt("precio_venta"));

                listado.add((producto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public clsProducto findbyId(clsProducto pro) {
        clsProducto producto = null;

        String sql = "SELECT id_producto, nombre,stock, precio_venta "
                + "FROM public.producto WHERE id_producto=?";

        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pro.getId_producto()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id_producto"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getInt("stock"));
                producto.setPrecio_venta(cres.getInt("precio_venta"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return producto;
    }

    public static clsProducto findbyId(int id_producto) {
        clsProducto producto = null;
        String sql = "SELECT  id_producto, nombre, stock, precio_venta"
                + "FROM public.producto WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_producto));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getInt("stock"));
                producto.setPrecio_venta(cres.getInt("precio_venta"));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return producto;
    }
}