
package examenprogra2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RENTAOBJETOS extends JFrame {
    private JTextArea textArea;

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
    }
}
