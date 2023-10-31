package aplicacion;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class interfaces {
	public static void main(String[] args) {

	      JFrame frame = new JFrame("lights out game");

	        frame.setSize(400, 300);
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JPanel panel = new JPanel();

	        frame.add(panel);

	        frame.setVisible(true);
	    }
}



