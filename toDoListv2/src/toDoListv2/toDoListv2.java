package toDoListv2;

public class toDoListv2 {

	public static void main(String[] args) {
		 GUI gui = new GUI();  // Create GUI first
	     new Database(gui);    // Load tasks from database
	}
}
