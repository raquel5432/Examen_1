
package examenprogra2;

 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class AGREGAR extends JFrame {



    private JComboBox<String> comboTipo;
    private JTextField txtCodigo, txtNombre, txtPrecio, txtImagen;
    private JButton btnGuardar;
    private ArrayList<RentItem> items;
    private JTextArea textArea;

    public AGREGAR(ArrayList<RentItem> items, JTextArea textArea) {
        this.items = items;
        this.textArea = textArea;

        setTitle("Agregar Item");
        setSize(600,400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,2,5,5));

        comboTipo = new JComboBox<>(new String[]{"Movie","Game"});
        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtImagen = new JTextField();
        btnGuardar = new JButton("Guardar");

        add(new JLabel("Tipo:"));
        add(comboTipo);

        add(new JLabel("Codigo:"));
        add(txtCodigo);

        add(new JLabel("Nombre:"));
        add(txtNombre);

        add(new JLabel("Precio (solo Movie):"));
        add(txtPrecio);

        add(new JLabel("Ruta Imagen:"));
        add(txtImagen);

        add(new JLabel(""));
        add(btnGuardar);

        // Mostrar precio solo si es Movie
        comboTipo.addActionListener(e -> {
            if(comboTipo.getSelectedItem().equals("Movie")){
                txtPrecio.setEnabled(true);
            } else {
                txtPrecio.setEnabled(false);
                txtPrecio.setText("");
            }
        });

        btnGuardar.addActionListener(e -> guardarItem());

        setVisible(true);
    }

    private void guardarItem() {
        String tipo = comboTipo.getSelectedItem().toString();
        String cod = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String ruta = txtImagen.getText();

        if(cod.isEmpty() || nombre.isEmpty()){
            JOptionPane.showMessageDialog(this,"Campos vacíos");
            return;
        }

        for(RentItem r : items){
            if(r.getCode().equals(cod)){
                JOptionPane.showMessageDialog(this,"Codigo duplicado");
                return;
            }
        }

        ImageIcon img = new ImageIcon(ruta);

            if(tipo.equals("Movie")){
               try{
                   double precio = Double.parseDouble(txtPrecio.getText());
                   items.add(new ClaseMovie(cod, nombre, precio, 1, img)); 
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(this,"Precio inválido");
                   return;
               }
           }
         else {
           // items.add(new GAME(cod,nombre,img));
        }

        textArea.append("Item agregado: "+cod+" - "+nombre+"\n");
        dispose();
    }
}

