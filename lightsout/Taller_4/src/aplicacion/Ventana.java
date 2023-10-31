package aplicacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    private JPanel contentPane;
    private JTextField txtTamao;
    private JTextField txtJugadas;
    private JTextField txtJugador;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana frame = new Ventana();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new Tablero(5);
        panel.setBounds(10, 49, 325, 321);
        contentPane.add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 128, 255));
        panel_1.setBounds(10, 10, 416, 35);
        contentPane.add(panel_1);

        txtTamao = new JTextField();
        txtTamao.setForeground(new Color(255, 255, 255));
        txtTamao.setBackground(new Color(0, 128, 255));
        txtTamao.setText("Tamaño:");
        panel_1.add(txtTamao);
        txtTamao.setColumns(6);

        JComboBox comboBox = new JComboBox();
        comboBox.setEditable(true);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"5x5", "6x6", "7x7", "8x8", "9x9", "10x10"}));
        panel_1.add(comboBox);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Facil");
        chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
        chckbxNewCheckBox.setBackground(new Color(0, 128, 255));
        panel_1.add(chckbxNewCheckBox);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Medio");
        chckbxNewCheckBox_1.setForeground(new Color(255, 255, 255));
        chckbxNewCheckBox_1.setBackground(new Color(0, 128, 255));
        panel_1.add(chckbxNewCheckBox_1);

        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Dificil");
        chckbxNewCheckBox_2.setBackground(new Color(0, 128, 255));
        chckbxNewCheckBox_2.setForeground(new Color(255, 255, 255));
        panel_1.add(chckbxNewCheckBox_2);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(345, 167, 115, 120);
        contentPane.add(panel_2);

        JButton btnNewButton_1 = new JButton("Reiniciar");
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        panel_2.add(btnNewButton_1);
        btnNewButton_1.setBackground(new Color(0, 128, 255));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón "Reiniciar" (puedes agregar tu lógica aquí)
            }
        });

        JButton btnNewButton = new JButton("Nuevo");
        btnNewButton.setForeground(new Color(255, 255, 255));
        panel_2.add(btnNewButton);
        btnNewButton.setBackground(new Color(0, 128, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón "Nuevo" (puedes agregar tu lógica aquí)
            }
        });

        JButton btnNewButton_2 = new JButton("top-10");
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        panel_2.add(btnNewButton_2);
        btnNewButton_2.setBackground(new Color(0, 128, 255));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el botón "top-10"
                // Crear y mostrar la ventana de los mejores puntajes
                VentanaTop10 top10 = new VentanaTop10();
                top10.setVisible(true);
            }
        });

        JButton btnNewButton_3 = new JButton("cambiar jugador");
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón "Cambiar Jugador" (puedes agregar tu lógica aquí)
            }
        });
        btnNewButton_3.setBackground(new Color(0, 128, 255));
        panel_2.add(btnNewButton_3);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 376, 416, 24);
        contentPane.add(panel_3);

        txtJugadas = new JTextField();
        txtJugadas.setForeground(new Color(255, 255, 255));
        txtJugadas.setBackground(new Color(0, 128, 255));
        txtJugadas.setText("Jugadas:");
        panel_3.add(txtJugadas);
        txtJugadas.setColumns(10);

        txtJugador = new JTextField();
        txtJugador.setText("Jugador");
    }
} 
