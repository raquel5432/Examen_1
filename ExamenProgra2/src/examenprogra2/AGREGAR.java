package examenprogra2;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;

public class AGREGAR extends JFrame {

    private JComboBox<String> comboTipo;
    private JTextField txtCodigo, txtNombre, txtPrecio, txtImagen;
    private JTextField txtDia, txtMes, txtAnio;
    private JButton btnGuardar;
    private ArrayList<RentItem> items;
    private JTextArea textArea;

    public AGREGAR(ArrayList<RentItem> items, JTextArea textArea) {
        this.items = items;
        this.textArea = textArea;

        setTitle("Agregar Item");
        setSize(650, 550);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 5, 5));

        comboTipo = new JComboBox<>(new String[]{"Movie", "Game"});
        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtImagen = new JTextField();
        
        // Fecha actual como valores por defecto
        Calendar hoy = Calendar.getInstance();
        txtDia = new JTextField(String.valueOf(hoy.get(Calendar.DAY_OF_MONTH)));
        txtMes = new JTextField(String.valueOf(hoy.get(Calendar.MONTH) + 1));
        txtAnio = new JTextField(String.valueOf(hoy.get(Calendar.YEAR)));
        
        btnGuardar = new JButton("Guardar");

        // Agregar componentes
        add(new JLabel("Tipo:"));
        add(comboTipo);

        add(new JLabel("Código:"));
        add(txtCodigo);

        add(new JLabel("Nombre:"));
        add(txtNombre);

        add(new JLabel("Precio Base (solo Movie):"));
        add(txtPrecio);

        add(new JLabel("Día Estreno (Movie):"));
        add(txtDia);

        add(new JLabel("Mes Estreno (Movie):"));
        add(txtMes);

        add(new JLabel("Año Estreno (Movie):"));
        add(txtAnio);

        add(new JLabel("Ruta de Imagen:"));
        add(txtImagen);

        add(new JLabel(""));
        add(btnGuardar);

        comboTipo.addActionListener(e -> {
            boolean isMovie = comboTipo.getSelectedItem().equals("Movie");
            txtPrecio.setEnabled(isMovie);
            txtDia.setEnabled(isMovie);
            txtMes.setEnabled(isMovie);
            txtAnio.setEnabled(isMovie);
            
            if(!isMovie) {
                txtPrecio.setText("");
                txtDia.setText("");
                txtMes.setText("");
                txtAnio.setText("");
            }
        });

        // Acción del botón guardar
        btnGuardar.addActionListener(e -> guardarItem());

        setVisible(true);
    }

    private void guardarItem() {
        String tipo = comboTipo.getSelectedItem().toString();
        String cod = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String ruta = txtImagen.getText().trim();

        // Validaciones básicas
        if(cod.isEmpty() || nombre.isEmpty()){
            JOptionPane.showMessageDialog(this, "Código y nombre son obligatorios");
            return;
        }

        // Validar código duplicado
        for(RentItem r : items){
            if(r.getCode().equals(cod)){
                JOptionPane.showMessageDialog(this, "Código duplicado");
                return;
            }
        }

        // Cargar imagen
                    ImageIcon img;
            try {
                if(ruta == null || ruta.trim().isEmpty()) {
                    // Usar imagen por defecto
                    java.net.URL imgURL = getClass().getResource("/resources.image/maze runner.jfif");
                    if(imgURL != null) {
                        img = new ImageIcon(imgURL);
                    } else {
                        img = new ImageIcon(); 
                    }
                } else {
                    img = new ImageIcon(ruta);
                    if(img.getImage() == null || img.getIconWidth() == -1) {
                        // Si la ruta es inválida, usar imagen por defecto
                        java.net.URL imgURL = getClass().getResource("/resources.image/maze runner.jfif");
                        if(imgURL != null) {
                            img = new ImageIcon(imgURL);
                            JOptionPane.showMessageDialog(this, "Ruta inválida, se usó imagen por defecto");
                        } else {
                            img = new ImageIcon();
                        }
                    }
                }
            } catch(Exception ex) {
                // En caso de error, usar imagen por defecto
                java.net.URL imgURL = getClass().getResource("/resources.image/maze runner.jfif");
                if(imgURL != null) {
                    img = new ImageIcon(imgURL);
                } else {
                    img = new ImageIcon();
                }
            }
                    // Crear según tipo
        if(tipo.equals("Movie")){
            try {
                double precio = Double.parseDouble(txtPrecio.getText());
                
                // Validar fecha
                if(txtDia.getText().isEmpty() || txtMes.getText().isEmpty() || txtAnio.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Debe ingresar fecha de estreno");
                    return;
                }
                
                int dia = Integer.parseInt(txtDia.getText());
                int mes = Integer.parseInt(txtMes.getText());
                int anio = Integer.parseInt(txtAnio.getText());
                
                // Crear Movie
                ClaseMovie movie = new ClaseMovie(cod, nombre, precio, 0, img);
                movie.setfechaEstreno(anio, mes, dia);
                items.add(movie);
                
                JOptionPane.showMessageDialog(this, "Película agregada correctamente");
                
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Precio o fecha invalida");
                return;
            }
        } 
        else { 
            GAME game = new GAME(cod, nombre, img);
            
            // Opcional: preguntar si quiere poner fecha de publicación
            int respuesta = JOptionPane.showConfirmDialog(this, 
                "¿Desea ingresar fecha de publicación?", 
                "Fecha de Game", 
                JOptionPane.YES_NO_OPTION);
            
            if(respuesta == JOptionPane.YES_OPTION) {
                try {
                    int dia = Integer.parseInt(JOptionPane.showInputDialog("Día:"));
                    int mes = Integer.parseInt(JOptionPane.showInputDialog("Mes:"));
                    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año:"));
                    game.setFechaPublicacion(anio, mes, dia);
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(this, "Fecha inválida, se usará fecha actual");
                }
            }
            
            items.add(game);
            JOptionPane.showMessageDialog(this, "Game agregado correctamente");
        }

        // Actualizar textArea
        textArea.append("Item agregado: " + cod + " - " + nombre + "\n");
        dispose();
    }
}