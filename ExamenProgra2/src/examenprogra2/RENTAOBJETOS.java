
package examenprogra2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RENTAOBJETOS extends JFrame {
    private JTextArea textArea;
    private ArrayList<RentItem>items;
    private JPanel itemsPanel;
    
    public RENTAOBJETOS(){
        iniciar();
    }
    
    private void iniciar(){
        items = new ArrayList<>();
        setLayout(new BorderLayout(10,10));
        setTitle("Renta de Objetos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        
        textArea  = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane,BorderLayout.CENTER);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5,1,10,10));
        JButton btnAgregar = new JButton("Agregar");
        JButton btnRentar=new JButton ("Rentar");
        JButton btnSubmenu= new JButton("Submenu");
        JButton btnImprimir= new JButton ("Imprimir Todo");
        JButton btnSalir = new JButton ("Salir");
        

        
        centerPanel.add(btnAgregar);
        centerPanel.add(btnRentar);
        centerPanel.add(btnSubmenu);
        centerPanel.add(btnImprimir);
        centerPanel.add(btnSalir);
        add(centerPanel, BorderLayout.CENTER);
        
        btnAgregar.addActionListener(e -> new AGREGAR(items, textArea));
btnRentar.addActionListener(e -> new VENTANARENTAR(items, textArea));
btnSubmenu.addActionListener(e -> {
    String cod = JOptionPane.showInputDialog("Codigo del Item:");
    if(cod==null) return;
    RentItem r = null;
    for(RentItem ri: items){
        if(ri.getCode().equals(cod)){ r = ri; break; }
    }
    if(r != null) new SubMenu(r);
});
btnImprimir.addActionListener(e -> new VentanaImprimir(items));
btnSalir.addActionListener(e -> System.exit(0));
    }
    
    
    private boolean codigoExiste(String cod){
         for(RentItem r: items){
             if(r.getCode().equals(cod))
                 return true;
        }
         return false;
    }
    
    
    private ImageIcon cargarImagen() {
          try {
            String path = JOptionPane.showInputDialog(this, "Ingrese LS ruta de  imagen:");
            if (path == null) return null;
            return new ImageIcon(path);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Imagen no cargada.");
            return null;
            }
        }
        
    private void agregarItem(){
          new AGREGAR(items, textArea);
        
    }

    
    private RentItem buscar(String cod){
        for(RentItem r : items){
            if(r.getCode().equals(cod)) return r;
        }
        return null;
    }


 
    
}
