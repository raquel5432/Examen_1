
package examenprogra2;

    import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubMenu extends JFrame {

    private RentItem item;

    public SubMenu(RentItem item){
        this.item = item;

        setTitle("Submenu Item");
        setSize(400,300);
        setLocationRelativeTo(null);

        if(item instanceof MenuActions){
            ((MenuActions)item).subMenu();
        } else {
            JOptionPane.showMessageDialog(this,"Este item no tiene submenu");
        }
    }

}
