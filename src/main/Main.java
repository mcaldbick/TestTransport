package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import test.TestWeb;

public class Main {

	public void createUI() {
		final JTextField text1 = new JTextField(30);
		JFrame frame = new JFrame("Test Transport Website");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new FlowLayout());

		JLabel label = new JLabel("Location of ChromeDriver.exe");

		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!(text1.getText().equals(""))) {
					System.out.println(text1.getText());

					TestWeb.testWeb(text1.getText());
					System.exit(0);

				} else {
					JOptionPane.showMessageDialog(null,
							"IEDriverServer location must not be empty.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		frame.add(label);
		frame.add(text1);
		frame.add(button);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(400, 200);
	}

	public static void main(String[] args) {
		Main se = new Main();
		se.createUI();
	}

}
