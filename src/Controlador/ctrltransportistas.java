
package Controlador;

import Modelo.consultastransportistas;
import Modelo.transportistas;
import Vista.frmtransportistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrltransportistas implements ActionListener{
    
    private transportistas mod;
    private consultastransportistas modC;
    private frmtransportistas frm;
    
    public ctrltransportistas (transportistas mod, consultastransportistas modC, frmtransportistas frm){
        
      this.mod = mod;
      this.modC = modC;
      this.frm = frm;
      this.frm.btnguardar.addActionListener(this);
      this.frm.btnmodificar.addActionListener(this);
      this.frm.btneliminar.addActionListener(this);
      this.frm.btnlimpiar.addActionListener(this);
      this.frm.jButton1.addActionListener(this);
    }

    
    
    public ctrltransportistas(transportistas tr, transportistas modC, frmtransportistas frm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ctrltransportistas(consultastransportistas tr, transportistas modC, frmtransportistas frm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void iniciar(){
        frm.setTitle("TRANSPORTISTAS");
        frm.setLocationRelativeTo(null);
    }
    /**
     *
     * @param e
     */
    @Override
    
    public void actionPerformed(ActionEvent e){
    if (e.getSource()==frm.btnguardar)  {
        mod.setNit(frm.tztnit.getText());
        mod.setNombre(frm.tztnombre.getText());
        mod.setTelefono(frm.tzttelefono.getText());
        
        if(modC.registrar(mod)){
            JOptionPane.showMessageDialog(null,"Registro Guarado");
            limpiar();
        }else{
            JOptionPane.showMessageDialog(null,"Error Al Guardar");
            limpiar();
        }
    }
    if(e.getSource() == frm.btnmodificar)
    {
        mod.setNit(frm.tztnit.getText());
        mod.setNombre(frm.tztnombre.getText());
        mod.setTelefono(frm.tzttelefono.getText());
        
        if(modC.modificar(mod)){
            
             JOptionPane.showMessageDialog(null, "Registro Modificado"); 
             limpiar ();
        }else{
             JOptionPane.showMessageDialog(null, "Error al Modificar");   
             limpiar ();
        }
    }
    
     if(e.getSource() == frm.btneliminar)
    {
        mod.setNit(frm.tztnit.getText());
      
        
        if(modC.eliminar(mod)){
            
             JOptionPane.showMessageDialog(null, "Registro Eliminado"); 
             limpiar ();
        }else{
             JOptionPane.showMessageDialog(null, "Error al Eliminar");   
             limpiar ();
        }
    }
     
     if(e.getSource() == frm.jButton1)
    {
        mod.setNit(frm.tztnit.getText());
      
        
        if(modC.buscar(mod)){
            
            
            frm.tztnit.setText(mod.getNit());
            frm.tztnombre.setText(mod.getNombre());
            frm.tzttelefono.setText(mod.getTelefono());

            
        }else{
             JOptionPane.showMessageDialog(null, "No se encontro el resultado");   
             limpiar ();
        }
    }
     if(e.getSource() == frm.btnlimpiar){
         limpiar ();
     }
    
}
    public void limpiar(){
       frm.tztnit.setText(null);
       frm.tztnombre.setText(null);
       frm.tzttelefono.setText(null);
    }

    public void Iniciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
