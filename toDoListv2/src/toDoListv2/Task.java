package toDoListv2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task extends JPanel{

	private JPanel taskPanel;
	private JButton deleteButton;
	private JTextPane taskField;
	
	public Task(JPanel taskPanel, String message) {
		this.taskPanel = taskPanel;
		
		taskField = new JTextPane();
		taskField.setPreferredSize(new Dimension(450, 50));
		taskField.setText(message);
		taskField.setEditable(false);
		
		deleteButton = new JButton("X");
		deleteButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deleteTask();
					}
				});
		
		add(taskField);
		add(deleteButton);
		
	}
	
	private void deleteTask() {
		//db.deleteTask(taskField.getText());
		taskPanel.remove(this);
		taskPanel.repaint();
		taskPanel.revalidate();
		
	}
	
}
