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
public class CreditCard extends Payment{

    public CreditCard(String product, int price, String name, String email) {
        super(product, price, name, email);
    }

    @Override
    public void startPayment() {
        Object[] ccOps = { "Mastercard", "Visa", "Falabella"};

        String creditcard = (String) JOptionPane.showInputDialog(
                null,
                "Que tarjeta desea usar?",
                "Tarjeta de crédito",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ccOps,
                "Mastercard");

        String ccNumber = (String) JOptionPane.showInputDialog("Digite su número de tarjeta de crédito");

        String ccPass = (String) JOptionPane.showInputDialog("Digite su código de seguridad");
        
        this.setReference(creditcard + "-" + ccNumber);
        
        this.setPaymentMethodType("Tarjeta de crédito");
        
        this.setStatus(true);
    }
    
}
