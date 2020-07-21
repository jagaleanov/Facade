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
public class PayPal extends Payment{
    
    public PayPal(String product, int price, String name, String email) {
        super(product, price, name, email);
    }

    @Override
    public void startPayment() {

        String ppUser = (String) JOptionPane.showInputDialog("Digite su usuario de PayPal");

        String ppPass = (String) JOptionPane.showInputDialog("Digite su contraseña PayPal");
        
        this.setReference(ppUser);
        
        this.setPaymentMethodType("PayPal");
        
        this.setStatus(true);
    }
    
}
