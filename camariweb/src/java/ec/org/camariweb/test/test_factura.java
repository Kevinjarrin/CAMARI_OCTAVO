/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.test;

import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.funciones.crudFactura;

public class test_factura {
    
     public static void main(String[] args) {
        
    clsFactura c = new clsFactura(2, null, null, 40, 10, 40.5);
    
        crudFactura cc = new crudFactura();

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
  
//         System.out.println("Comprobando si hay datos");
//        System.out.println(cc.findbyId(c).toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Eliminando");
//        if (cc.delete(c)) {
//            System.out.println("eliminado");
//        } else {
//            System.out.println("no se ha podido eliminar");
//        }
//
//
//
//        System.out.println("Comprobando si hay datos");
//        System.out.println(cc.findbyId(c).toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Actualizando");
//        if (cc.update(c)) {
//            System.out.println("Actualizado");
//        } else {
//            System.out.println("no se ha podido actualizar");
//        }

//
//        System.out.println("Comprobando si hay datos");
//        System.out.println(cc.findbyId(c).toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Listando");
//        if (cc.findbyAll(c)) {
//            System.out.println("Listado");
//        } else {
//            System.out.println("no se ha podido listar");
//        }
     }        
}
