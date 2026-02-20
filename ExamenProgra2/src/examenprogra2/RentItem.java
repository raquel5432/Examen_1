
package examenprogra2;

import javax.swing.ImageIcon;




/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public abstract class RentItem {
 
    protected String Code;
    protected String Name;
    protected double precioBase;
    protected int copies;
    protected ImageIcon image;
    
    
    public RentItem(String Code, String Name, double precioBase, int copies, ImageIcon image){
        
        this.Code = Code;
        this.Name = Name;
        this.copies = 0;
        this.precioBase = precioBase;
        this.image = image;
  
    }
    
    public String getCode(){
        return Code;
    }
    
    public String getName(){
        return Name;
    }
    
    public double getPreciobase(){
        return precioBase;
    }
    
    public ImageIcon getImaged(){
        return image;
    }
    
 @Override
public String toString() {
    return "Codigo: " + Code +
           "\nNombre: " + Name +
           "\nPrecio Base: L." + precioBase +
           "\nCopias: " + copies;
}
    
    public abstract double pagoRenta(int dias);
}
