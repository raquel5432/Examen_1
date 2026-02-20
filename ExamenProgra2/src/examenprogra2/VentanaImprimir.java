
package examenprogra2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaImprimir extends JFrame {

    public VentanaImprimir(ArrayList<RentItem> items){
        setTitle("Lista de Items");
        setSize(500,400);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);

        StringBuilder sb = new StringBuilder();
        if(items.isEmpty()){
            sb.append("No hay items\n");
        } else {
            for(RentItem r : items){
                sb.append("---------------\n");
                sb.append(r.toString()).append("\n");
            }
        }

        area.setText(sb.toString());
        add(scroll);
        setVisible(true);
    }
}