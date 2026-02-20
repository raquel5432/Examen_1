
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
    
    
    public RENTAOBJETOS(){
        iniciar();
    }
    
    private void iniciar(){
        setTitle("Renta de Objetos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        
        textArea  = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane,BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1,5,5,5));
        JButton btnAgregar = new JButton("Agregar");
        JButton btnRentar=new JButton ("Rentar");
        JButton btnSubmenu= new JButton("Submenu");
        JButton btnImprimir= new JButton ("Imprimir Todo");
        JButton btnSalir = new JButton ("Salir");
        
        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnRentar);
        buttonPanel.add(btnSubmenu);
        buttonPanel.add(btnImprimir);
        buttonPanel.add(btnSalir);
        add(buttonPanel, BorderLayout.SOUTH);
        
        

            btnSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
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
        
    private void agregarItem({
        String[]opciones ={"Movie","Game"};
        int tipo = JOptionPane.showOptionDialog(this, "Seleccione tipo:","Agregar",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
        if(tipo==-1)return;
        
        String cod = JOptionPane.showInputDialog(this,"Codigo: ");
        if(cod == null || cod.trim().isEmpty())return;
        if(codigoExiste(cod)){
            JOptionPane.showMessageDialog(this, "Codigo duplicado.");
            return;
        }
        
        
    });

    
    
}
