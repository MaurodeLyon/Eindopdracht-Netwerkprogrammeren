package recusiveDrawing;

import java.awt.GridLayout;

import javax.swing.JFrame;

import recursion.Optellen;

public class Launch {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Recursion");
		frame.setLayout(new GridLayout(2, 2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new Square());
		frame.add(new Panel());
		frame.add(new Triangle());
		frame.add(new Circles());
		new Optellen();
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}
}
