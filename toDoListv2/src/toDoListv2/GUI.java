package toDoListv2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
	
	private JTextArea text;
	private JTextField input;
	private JButton add_button;
	private JPanel panel;
	private JLabel label;
	private JPanel task_panel;
	private Database db;
	
	public GUI() {
		JFrame frame = new JFrame();
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		task_panel = new JPanel();
		JScrollPane scroll = new JScrollPane(task_panel);
		task_panel.setLayout(new BoxLayout(task_panel, BoxLayout.Y_AXIS));

		panel = new JPanel();
		
		input = new JTextField(30);
		input.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						add_task(input.getText());
					}
				});
		
		add_button = new JButton("ADD");
		add_button.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						add_task(input.getText());
					}
				});
		
		panel.add(input);
		panel.add(add_button);
		
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		
	}
	
	public void add_task(String message) {
		Task task = new Task(task_panel, message);	
		
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						task_panel.add(task);
						task_panel.repaint();
						task_panel.revalidate();
					}
				});
		
		input.setText("");
	}
	
}
