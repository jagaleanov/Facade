/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import mediosPago.CreditCard;
import mediosPago.PSE;
import mediosPago.PayPal;
import mediosPago.Payment;

/**
 *
 * @author jgale
 */
public class Facade {

    ArrayList<Payment> payments;

    public Facade() {
        this.startOperation();
    }

    public void startOperation() {

        payments = new ArrayList<Payment>();

        Object[] operationOps = {"Pago", "Ver facturas", "Cerrar"};

        boolean next = true;

        while (next) {

            String operationSelected = (String) JOptionPane.showInputDialog(
                    null,
                    "Que operación desea realizar?",
                    "Operación",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    operationOps,
                    "PSE");

            if (operationSelected.equals("Pago")) {
                this.makePayment();
            } else if (operationSelected.equals("Ver facturas")) {
                this.viewVouchers();
            } else {
                next = false;
            }
        }
    }

    public void viewVouchers() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(payments.size() + 1, 3));
        panel.add(new JLabel("ID"));
        panel.add(new JLabel("PRODUCTO"));
        panel.add(new JLabel("VALOR"));

        for (Payment payment : payments) {

            panel.add(new JButton(String.valueOf(payment.getId())));
            JLabel label = new JLabel(payment.getProduct());
            

            Border border = label.getBorder();
            Border margin = new EmptyBorder(10, 10, 10, 10);
            
            label.setBorder(new CompoundBorder(border, margin));
            panel.add(label);
            
            panel.add(new JLabel("$ " + String.valueOf(payment.getPrice())));
        }

        JOptionPane.showMessageDialog(null, panel, "FACTURA", JOptionPane.INFORMATION_MESSAGE);

    }

    public void makePayment() {

        Payment payment;

        String product = (String) JOptionPane.showInputDialog("Que producto desea comprar");

        String pricetxt = (String) JOptionPane.showInputDialog("Cual es el valor a pagar?");
        int price = Integer.parseInt(pricetxt);

        String name = (String) JOptionPane.showInputDialog("Nombre del comprador");

        String email = (String) JOptionPane.showInputDialog("Email del comprador");

        Object[] paymMetOps = {"PSE", "Tarjeta de crédito", "PayPal"};

        String paymMetSelected = (String) JOptionPane.showInputDialog(
                null,
                "Que medio de pago desea usar?",
                "Medio de pago",
                JOptionPane.QUESTION_MESSAGE,
                null,
                paymMetOps,
                "PSE");

        switch (paymMetSelected) {
            case "PSE":
                payment = new PSE(product, price, name, email);
                break;
            case "Tarjeta de crédito":
                payment = new CreditCard(product, price, name, email);
                break;
            case "PayPal":
                payment = new PayPal(product, price, name, email);
                break;
            default:
                payment = new PayPal(product, price, name, email);
                break;
        }

        payment.startPayment();

        if (payment.isPaid()) {
            this.insertPayment(payment);
            payment.printVoucher();
        }
    }

    public void insertPayment(Payment payment) {

        int position = payments.size();
        payment.setId(position);
        payments.add(payment);
    }
}
