/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediosPago;

import javax.swing.JOptionPane;

/**
 *
 * @author jgale
 */
public abstract class Payment {
    
    int id;
    
    String paymentMethodType;
    
    String product;
    int price;
    
    boolean status;
    
    String name;
    String email;
    
    String reference;
    
    public Payment (String product, int price, String name, String email) {
        this.product = product;
        this.price = price;
        this.name = name;
        this.email = email;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPaid() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public void printVoucher() {
        String message = 
                "<html>"
                + "FACTURA N° " + this.getId() + "<br><br>"
                + "CLIENTE:" +  this.getName() + "<br><br>"
                + "EMAIL:" +  this.getEmail() + "<br><br>"
                + "PRODUCTO:<br>"
                + this.getProduct() + "<br><br>"
                + "REFERENCIA:<br>"
                + this.getReference()+ "<br><br>"
                + "VALOR: $" + this.getPrice()+ "<br><br>"
                
                + "</html>";
        JOptionPane.showMessageDialog(null, message, "FACTURA", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public abstract void startPayment();
    
    
    
}
