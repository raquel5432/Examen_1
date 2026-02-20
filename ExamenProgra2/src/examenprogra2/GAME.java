
package examenprogra2;


import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;





import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class GAME extends RentItem implements MenuActions{
    private Calendar fechaPublicacion;
    private ArrayList<String> especificaciones;
   
    public GAME(String codigo, String nombre, ImageIcon imagen){
        super(codigo, nombre, 20, 0, imagen);
        fechaPublicacion = Calendar.getInstance();
        especificaciones = new ArrayList<>();
    }

    
    public void setFechaPublicacion(int y, int m, int d){
    fechaPublicacion.set(Calendar.YEAR, y);
    fechaPublicacion.set(Calendar.MONTH, m - 1);
    fechaPublicacion.set(Calendar.DAY_OF_MONTH, d);;
    }
    
    public void listEspecificaciones() {
    if(especificaciones.isEmpty()){
        JOptionPane.showMessageDialog(null, "No hay especificaciones.");
    } else {
        mostrarEspecificacionesRec(0, "");
    }
}
    
    @Override
    public double pagoRenta(int dias){
        return 20 * dias;
    }
    
    @Override
    public String toString(){
        return super.toString() + 
                "\nFecha Publicacion: " + fechaPublicacion.getTime() +
                " - PS3 Game";
    }

    
    @Override
    public void subMenu() {
        String menu =
                "1) Actualizar Fecha de Publicacion\n" +
                "2) Agregar Especificacion\n" +
                "3) Ver Especificaciones\n";
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
        ejecutarOpcion(op);
    }
    
    @Override
    public void ejecutarOpcion(int opcion) {
        switch(opcion) {
            case 1:
                try {
               int y = Integer.parseInt(JOptionPane.showInputDialog("Año:"));
               int m = Integer.parseInt(JOptionPane.showInputDialog("Mes:"));
               int d = Integer.parseInt(JOptionPane.showInputDialog("Día:"));
               setFechaPublicacion(y, m, d);

               JOptionPane.showMessageDialog(null, 
                   "Fecha actualizada a: " + 
                   fechaPublicacion.get(Calendar.DAY_OF_MONTH) + "/" +
                   (fechaPublicacion.get(Calendar.MONTH) + 1) + "/" +
                   fechaPublicacion.get(Calendar.YEAR));
           } catch(Exception ex) {
               JOptionPane.showMessageDialog(null, "Fecha inválida");
           }
                
           break;
            case 2:
                String esp= JOptionPane.showInputDialog("Nueva especificacion:");
                especificaciones.add(esp);
                JOptionPane.showMessageDialog(null, "Agregada.");
                break;
                
            case 3:
                listEspecificaciones();
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida.");
        }
    }
    
    private void mostrarEspecificacionesRec(int i, String acumulado) {
        if (i == especificaciones.size()) {
            JOptionPane.showMessageDialog(null, acumulado);
            return;
        }
        
        mostrarEspecificacionesRec(i + 1, acumulado + "- " + especificaciones.get(i)+ "\n");
    }


}
   
    

