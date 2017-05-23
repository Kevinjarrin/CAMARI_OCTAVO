/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.test;

import ec.org.camariweb.entidades.clsDFacturaProducto;
import ec.org.camariweb.funciones.crudDFacturaProducto;

public class test_dfacturaproducto {

    public static void main(String[] args) {

        clsDFacturaProducto c = new clsDFacturaProducto(1, null, null, 10, 24);
        crudDFacturaProducto cc = new crudDFacturaProducto();

        System.out.println("Prueba de clases");
        System.out.println("=============================================");
        System.out.println("contenido de la clase c");
        System.out.println(c.toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("INSERTANDO");
        if (cc.save(c)) {
            System.out.println("Guardado");
        } else {
            System.out.println("error!!!!");
        }

    
         System.out.println("Comprobando si hay datos");
        System.out.println(cc.findbyId(c).toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("Eliminando");
        if (cc.delete(c)) {
            System.out.println("eliminado");
        } else {
            System.out.println("no se ha podido eliminar");
        }



        System.out.println("Comprobando si hay datos");
        System.out.println(cc.findbyId(c).toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("Actualizando");
        if (cc.update(c)) {
            System.out.println("Actualizado");
        } else {
            System.out.println("no se ha podido actualizar");
        }
    }

}
