import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConversorDivisas implements ActionListener {
    
    private JFrame frame;
    private JTextField txtMonto;
    private JComboBox<String> cmbMonedaOrigen;
    private JComboBox<String> cmbMonedaDestino;
    private JLabel lblResultado;
    
    public ConversorDivisas() {
        
        // Crear los componentes de la interfaz
        frame = new JFrame("Conversor de Divisas");
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lblMonto = new JLabel("Monto:");
        txtMonto = new JTextField();
        JLabel lblMonedaOrigen = new JLabel("Moneda de Origen:");
        cmbMonedaOrigen = new JComboBox<String>(new String[] {"USD", "EUR", "MXN", "PER"});
        JLabel lblMonedaDestino = new JLabel("Moneda de Destino:");
        cmbMonedaDestino = new JComboBox<String>(new String[] {"USD", "EUR", "MXN", "PER"});
        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.addActionListener(this);
        lblResultado = new JLabel();
        
        // Agregar los componentes al frame
        frame.add(lblMonto);
        frame.add(txtMonto);
        frame.add(lblMonedaOrigen);
        frame.add(cmbMonedaOrigen);
        frame.add(lblMonedaDestino);
        frame.add(cmbMonedaDestino);
        frame.add(btnConvertir);
        frame.add(lblResultado);
        
        // Mostrar la ventana
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        // Obtener los valores de los componentes
        double monto = Double.parseDouble(txtMonto.getText());
        String monedaOrigen = (String) cmbMonedaOrigen.getSelectedItem();
        String monedaDestino = (String) cmbMonedaDestino.getSelectedItem();
        
        // Convertir el monto de la moneda de origen a la moneda de destino
        double montoConvertido = 0;
        switch (monedaOrigen) {
            case "USD":
                montoConvertido = monto;
                break;
            case "EUR":
                montoConvertido = monto * 1.07;
                break;
            case "MXN":
                montoConvertido = monto * 0.053;
                break;
            case "PER":
                montoConvertido = monto * 0.26;
        }
        switch (monedaDestino) {
            case "USD":
                break;
            case "EUR":
                montoConvertido /= 1.07;
                break;
            case "MXN":
                montoConvertido /= 0.053;
                break;
            case "PER":
                montoConvertido /= 0.26;
        }
        
        // Mostrar el resultado en la interfaz
        lblResultado.setText(String.format("El monto convertido es " + montoConvertido + " " + monedaDestino));
    }
    
    public static void main(String[] args) {
        new ConversorDivisas();
    }
}
