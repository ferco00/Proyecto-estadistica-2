
package distribucionesgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DistribucionesGUI extends JFrame {

    private JTextField textFieldN;
    private JTextField textFieldP;
    private JTextField textFieldX;
    private JTextField textFieldNHyper;
    private JTextField textFieldKHyper;
    private JTextField textFieldNSample;
    private JTextField textFieldXSample;
    private JTextField textFieldLambda;
    private JTextField textFieldXPoisson;
    private JTextArea resultTextArea;

    public DistribucionesGUI() {
        setTitle("Distribuciones de Probabilidad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setBackground(new Color(0, 0, 0)); // Azul claro

        // Distribución Binomial
        JLabel labelBinomial = createLabel("Distribución Binomial", Color.WHITE);

        JLabel labelN = createLabel("Número de ensayos (n):", Color.WHITE);
        JLabel labelP = createLabel("Probabilidad de éxito (p):", Color.WHITE);
        JLabel labelX = createLabel("Número de éxitos (x):", Color.WHITE);

        textFieldN = createTextField();
        textFieldP = createTextField();
        textFieldX = createTextField();

        JButton btnBinomial = createButton("Calcular Binomial");
        btnBinomial.addActionListener(e -> calcularBinomial());

        // Distribución Hipergeométrica
        JLabel labelHyper = createLabel("Distribución Hipergeométrica", Color.WHITE);
        JLabel labelNHyper = createLabel("Tamaño de la población (N):", Color.WHITE);
        JLabel labelKHyper = createLabel("Número de éxitos en la población (K):", Color.WHITE);
        JLabel labelNSample = createLabel("Tamaño de la muestra (n):", Color.WHITE);
        JLabel labelXSample = createLabel("Número de éxitos en la muestra (x):", Color.WHITE);

        textFieldNHyper = createTextField();
        textFieldKHyper = createTextField();
        textFieldNSample = createTextField();
        textFieldXSample = createTextField();

        JButton btnHyper = createButton("Calcular Hipergeométrica");
        btnHyper.addActionListener(e -> calcularHipergeometrica());

        // Distribución de Poisson
        JLabel labelPoisson = createLabel("Distribución de Poisson", Color.WHITE);
        JLabel labelLambda = createLabel("Tasa de ocurrencia (lambda):", Color.WHITE);
        JLabel labelXPoisson = createLabel("Número de eventos deseados (x):", Color.WHITE);

        textFieldLambda = createTextField();
        textFieldXPoisson = createTextField();

        JButton btnPoisson = createButton("Calcular Poisson");
        btnPoisson.addActionListener(e -> calcularPoisson());

        // Resultados
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);
        resultTextArea.setBackground(new Color(248, 0, 0)); // Azul claro
        resultTextArea.setForeground(Color.BLACK);

        // Layout
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelBinomial)
                        .addComponent(labelN)
                        .addComponent(textFieldN)
                        .addComponent(labelP)
                        .addComponent(textFieldP)
                        .addComponent(labelX)
                        .addComponent(textFieldX)
                        .addComponent(btnBinomial))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelHyper)
                        .addComponent(labelNHyper)
                        .addComponent(textFieldNHyper)
                        .addComponent(labelKHyper)
                        .addComponent(textFieldKHyper)
                        .addComponent(labelNSample)
                        .addComponent(textFieldNSample)
                        .addComponent(labelXSample)
                        .addComponent(textFieldXSample)
                        .addComponent(btnHyper))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelPoisson)
                        .addComponent(labelLambda)
                        .addComponent(textFieldLambda)
                        .addComponent(labelXPoisson)
                        .addComponent(textFieldXPoisson)
                        .addComponent(btnPoisson))
                .addComponent(resultTextArea)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelBinomial)
                        .addComponent(labelHyper)
                        .addComponent(labelPoisson))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelN)
                        .addComponent(textFieldN)
                        .addComponent(labelNHyper)
                        .addComponent(textFieldNHyper)
                        .addComponent(labelLambda)
                        .addComponent(textFieldLambda))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelP)
                        .addComponent(textFieldP)
                        .addComponent(labelKHyper)
                        .addComponent(textFieldKHyper)
                        .addComponent(labelXPoisson)
                        .addComponent(textFieldXPoisson))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelX)
                        .addComponent(textFieldX)
                        .addComponent(labelNSample)
                        .addComponent(textFieldNSample))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelXSample)
                        .addComponent(textFieldXSample))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBinomial)
                        .addComponent(btnHyper)
                        .addComponent(btnPoisson))
                .addComponent(resultTextArea)
        );

        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(10);
        textField.setBackground(new Color(106, 137, 204)); // Azul medio
        textField.setForeground(Color.BLACK);
        textField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        return textField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(45, 82, 160)); // Azul oscuro
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        return button;
    }

    private void calcularBinomial() {
        try {
            int n = Integer.parseInt(textFieldN.getText());
            double p = Double.parseDouble(textFieldP.getText());
            int x = Integer.parseInt(textFieldX.getText());

            double probabilidad = calcularDistribucionBinomial(n, p, x);
            mostrarResultado("Distribución Binomial: " + probabilidad);
        } catch (NumberFormatException e) {
            mostrarError("Ingrese números válidos para la distribución binomial.");
        }
    }

    private double calcularDistribucionBinomial(int n, double p, int x) {
        double q = 1 - p;
        return factorial(n) / (factorial(x) * factorial(n - x)) * Math.pow(p, x) * Math.pow(q, n - x);
    }

    private void calcularHipergeometrica() {
        try {
            int N = Integer.parseInt(textFieldNHyper.getText());
            int K = Integer.parseInt(textFieldKHyper.getText());
            int n = Integer.parseInt(textFieldNSample.getText());
            int x = Integer.parseInt(textFieldXSample.getText());

            double probabilidad = calcularDistribucionHipergeometrica(N, K, n, x);
            mostrarResultado("Distribución Hipergeométrica: " + probabilidad);
        } catch (NumberFormatException e) {
            mostrarError("Ingrese números válidos para la distribución hipergeométrica.");
        }
    }

    private double calcularDistribucionHipergeometrica(int N, int K, int n, int x) {
        return (combinatoria(K, x) * combinatoria(N - K, n - x)) / combinatoria(N, n);
    }

    private void calcularPoisson() {
        try {
            double lambda = Double.parseDouble(textFieldLambda.getText());
            int x = Integer.parseInt(textFieldXPoisson.getText());

            double probabilidad = calcularDistribucionPoisson(lambda, x);
            mostrarResultado("Distribución de Poisson: " + probabilidad);
        } catch (NumberFormatException e) {
            mostrarError("Ingrese números válidos para la distribución de Poisson.");
        }
    }

    private double calcularDistribucionPoisson(double lambda, int x) {
        return (Math.pow(Math.E, -lambda) * Math.pow(lambda, x)) / factorial(x);
    }

    private double combinatoria(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private double factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    private void mostrarResultado(String resultado) {
        resultTextArea.setText(resultado);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new DistribucionesGUI().setVisible(true);
        });
    }
}
