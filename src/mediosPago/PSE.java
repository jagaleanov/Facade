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
public class PSE extends Payment {

    public PSE(String product, int price, String name, String email) {
        super(product, price, name, email);
    }

    @Override
    public void startPayment() {
        Object[] bankOps = {"Bancolombia", "AK Villas", "Davivienda"};

        String bankSelected = (String) JOptionPane.showInputDialog(
                null,
                "Que banco desea usar?",
                "Banco",
                JOptionPane.QUESTION_MESSAGE,
                null,
                bankOps,
                "Bancolombia");

        String bankAccount = (String) JOptionPane.showInputDialog("Digite su número de cuenta");

        String bankPassword = (String) JOptionPane.showInputDialog("Digite su clave bancaria");
        
        this.setReference(bankSelected + "-" + bankAccount);
        
        this.setPaymentMethodType("PSE");
        
        this.setStatus(true);
    }

}
