/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenprogra2;

/**
 *
 * @author Dell
 */

    import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VENTANARENTAR extends JFrame {

    private JTextField txtCodigo, txtDias;
    private JButton btnRentar;
    private ArrayList<RentItem> items;
    private JTextArea textArea;

    public VENTANARENTAR(ArrayList<RentItem> items, JTextArea textArea){
        this.items = items;
        this.textArea = textArea;

        setTitle("Rentar Item");
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2,5,5));

        txtCodigo = new JTextField();
        txtDias = new JTextField();
        btnRentar = new JButton("Rentar");

        add(new JLabel("Codigo del Item:"));
        add(txtCodigo);

        add(new JLabel("Dias a Rentar:"));
        add(txtDias);

        add(new JLabel(""));
        add(btnRentar);

        btnRentar.addActionListener(e -> rentar());

        setVisible(true);
    }

    private void rentar(){
        String cod = txtCodigo.getText();
        String diasStr = txtDias.getText();

        if(cod.isEmpty() || diasStr.isEmpty()){
            JOptionPane.showMessageDialog(this,"Campos vacíos");
            return;
        }

        RentItem r = null;
        for(RentItem ri : items){
            if(ri.getCode().equals(cod)){
                r = ri;
                break;
            }
        }

        if(r == null){
            JOptionPane.showMessageDialog(this,"Item no existe");
            return;
        }

        int dias;
        try{
            dias = Integer.parseInt(diasStr);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Dias inválido");
            return;
        }

        double total = r.pagoRenta(dias);

        JOptionPane.showMessageDialog(this,r.toString() + "\nTotal a pagar: L."+total,
                "Renta", JOptionPane.INFORMATION_MESSAGE, r.getImaged());

        textArea.append("Renta de " + cod + " por " + dias + " dias: TOTAL L."+total+"\n");
        dispose();
    }

}
