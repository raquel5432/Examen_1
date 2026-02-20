package examenprogra2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaImprimir extends JFrame {

    public VentanaImprimir(ArrayList<RentItem> items){
        setTitle("Lista de Items");
        setSize(600,500);
        setLocationRelativeTo(null);
        
      
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        if(items.isEmpty()){
            mainPanel.add(new JLabel("No hay items"));
        } else {
            for(RentItem r : items){
                
                
                JPanel card = new JPanel(new BorderLayout(10,10));
                card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                card.setMaximumSize(new Dimension(550, 150));
                
                JLabel lblImagen = new JLabel();
                try {
                    if(r.getImaged() != null && r.getImaged().getImage() != null) {
                        ImageIcon img = r.getImaged();
                        Image image = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        lblImagen.setIcon(new ImageIcon(image));
                    } else {
                        // Si no hay imagen, poner un texto o un icono por defecto
                        lblImagen.setText("Sin imagen");
                        lblImagen.setPreferredSize(new Dimension(100, 100));
                        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                        lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    }
                } catch(Exception e) {
                    lblImagen.setText("Error imagen");
                    lblImagen.setPreferredSize(new Dimension(100, 100));
                    lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                    lblImagen.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
                
                JTextArea txtInfo = new JTextArea();
                txtInfo.setEditable(false);
                
                String estado = "";
                if(r instanceof ClaseMovie) {
                    estado = "\nEstado: " + ((ClaseMovie)r).getEstado();
                }
                
                txtInfo.setText(r.toString() + estado + 
                              "\nPrecio Renta/día: L." + r.getPreciobase());
                
                card.add(lblImagen, BorderLayout.WEST);
                card.add(txtInfo, BorderLayout.CENTER);
                
                mainPanel.add(card);
                mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        }
        
        JScrollPane scroll = new JScrollPane(mainPanel);
        add(scroll);
        setVisible(true);
    }
}