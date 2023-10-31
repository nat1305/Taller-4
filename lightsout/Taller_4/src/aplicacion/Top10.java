package aplicacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Top10 extends JFrame {
    private JPanel contentPane;

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

    public Top10() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnTop10 = new JButton("top-10");
        btnTop10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el botón "Top 10"
                // Crear y mostrar la ventana de los mejores puntajes
                VentanaTop10 top10 = new VentanaTop10();
                top10.setVisible(true);
            }
        });
        btnTop10.setBounds(10, 10, 100, 30);
        contentPane.add(btnTop10);
    }
}

class VentanaTop10 extends JFrame {
    private JPanel contentPane;

    public VentanaTop10() {
        setTitle("Top 10 Puntajes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Aquí puedes agregar una lista de puntajes y mostrarla en la ventana.
        // Por ejemplo, puedes usar una JTable para mostrar la lista.

        // Ejemplo de creación de una tabla de puntajes (debes personalizarla según tus necesidades):
        String[] columnNames = {"Nombre", "Puntaje"};
        Object[][] data = {
            {"Jugador1", 1000},
            {"Jugador2", 800},
            {"Jugador3", 700},
            // Agrega más puntajes aquí...
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 364, 200);
        contentPane.add(scrollPane);
    }
}
