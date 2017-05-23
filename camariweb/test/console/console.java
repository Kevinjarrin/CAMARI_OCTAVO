/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.funciones.clsReportes;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class console {
    
     public static void main(String[] args) {
     
    //clsReportes r= new clsReportes();     
    ArrayList<clsFactura> factura = new ArrayList<>();
    factura = clsReportes.clienteFacturaMayorMil();
    
    System.out.println(factura.toString());
     }
}
