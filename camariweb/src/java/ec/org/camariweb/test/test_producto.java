/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.test;

import ec.org.camariweb.entidades.clsProducto;
import ec.org.camariweb.funciones.crudProducto;


public class test_producto {
    
    public static void main(String[] args) {
        
    clsProducto c = new clsProducto(5, " leche", 5, 15.2);
    
        crudProducto cc = new crudProducto();

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