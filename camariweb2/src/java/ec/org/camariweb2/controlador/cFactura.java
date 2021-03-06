
package ec.org.camariweb2.controlador;

import ec.org.camariweb2.entidades.clsFactura;
import ec.org.camariweb2.funciones.crudFactura;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class cFactura {
    
     private List<clsFactura> Lista;
    private clsFactura newFactura; //Cuando ingrese un producto nuevo 
    private clsFactura selectedFactura; // cuando selecione un Producto para borrar o actualizar

    public cFactura() {
        
         newFactura= new clsFactura();
        cargarDatos();
    }
    
    private void cargarDatos(){
    
        Lista = crudFactura.findbyAll();
    }
    
    
    private void insertar(){
            if (crudFactura.save(newFactura)){ //esta linea guarda el cliente
                newFactura = new clsFactura(); //prepara el constructor de un posible nuevo cliente
                cargarDatos();                  //refresca el datagrid con los cambios (Aparece el nuevo cliente)
                //mostrar mensaje
                
            }
            else
            {
                //mostrar mensaje de no guardado
            }
        }
        
        private void eliminar ()
        {
            if(crudFactura.delete(selectedFactura)){
                if (crudFactura.save(newFactura)){
                    
                    newFactura = new clsFactura();
                    cargarDatos();
                }
            }
        }
        
        
        private void actualizar ()
        {
             if(crudFactura.update(selectedFactura)){
                if (crudFactura.save(newFactura)){
                    
                    newFactura = new clsFactura();
                    cargarDatos();
                }
            }
        }

    public List<clsFactura> getLista() {
        return Lista;
    }

    public void setLista(List<clsFactura> Lista) {
        this.Lista = Lista;
    }

    public clsFactura getNewFactura() {
        return newFactura;
    }

    public void setNewFactura(clsFactura newFactura) {
        this.newFactura = newFactura;
    }

    public clsFactura getSelectedFactura() {
        return selectedFactura;
    }

    public void setSelectedFactura(clsFactura selectedFactura) {
        this.selectedFactura = selectedFactura;
    }

    @Override
    public String toString() {
        return "cFactura{" + "Lista=" + Lista + ", newFactura=" + newFactura + ", selectedFactura=" + selectedFactura + '}';
    }
        
   
}
