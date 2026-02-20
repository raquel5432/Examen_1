/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenprogra2;

import java.util.Calendar;
import javax.swing.ImageIcon;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public class ClaseMovie extends RentItem {
 
    private Calendar fechaEstreno;

    public ClaseMovie(String Code, String Name, double precioBase, int copies, ImageIcon image) {
        super(Code, Name, precioBase, copies, image);
        this.fechaEstreno = Calendar.getInstance();
    }

    
    public Calendar getFechaEstreno(){
        return fechaEstreno;
    }
    
    public void setfechaEstreno(int year, int month, int day){
        
        Calendar c = Calendar.getInstance();
        c.set(year, month -1, day);
        this.fechaEstreno = c;
    }
    
    public String getEstado(){
        
        Calendar hoy = Calendar.getInstance();
        int months = monthsBetween(fechaEstreno, hoy);
        if (months <= 3) {
            return "ESTRENO";
        }else{
            return "NORMAL";
        }
    }
    
    private int monthsBetween(Calendar a, Calendar b){
        
       int yearDiff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
       int monthDiff = b.get(Calendar.MONTH) - a.get(Calendar.MONTH);
       int total = yearDiff * 12 + monthDiff;
       
       if (total <0){
           
           total = 0;
       }
       return total;
    }

    @Override
    public double pagoRenta(int dias) {
        
        if (dias <= 0){
            return 0;
        }

        double total = precioBase *dias;
        
        if (getEstado().equals("ESTRENO")) {
            if (dias > 2) {
                total += (dias - 2) * 50.0; 
             }
        }
             
   
        else if (getEstado().equals("NORMAL")) {
            if (dias > 5) {
                total += (dias - 5) * 30.0;
            }              
        }return total;
    }
    
    @Override
    public String toString() {
        return super.toString() +
               "\nEstado: " + getEstado() +
               "\n- Movie";
    }
}
