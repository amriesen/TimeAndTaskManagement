package views;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import model.ToDoTask;
import model.ToDoTaskManager;

public class GuiController implements Initializable{

	@FXML
	TreeView<String> taskTree;
	
	@FXML
	Label taskLabel;
	
	@FXML 
	Label testLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		ToDoTaskManager toDoTaskManager = ToDoTaskManager.getInstance();
		List<ToDoTask> taskList = toDoTaskManager.getAllTasks(null);

		
		
		taskTree.setShowRoot(false);
		
		TreeItem<String> taskTreeRoot = new TreeItem<>();
		
		for (ToDoTask task : taskList) {
			TreeItem<String> taskDescription = new TreeItem<>(task.getDescription());
			taskTreeRoot.getChildren().add(taskDescription);	
		}
		
		taskTree.setRoot(taskTreeRoot);
		
		updateDetailView(taskList.get(0));
	}
	
	/**
	 * Method to update the Task Tree from the database.
	 */
	public void updateTaskTree() {
		
		ToDoTaskManager toDoTaskManager = ToDoTaskManager.getInstance();
		List<ToDoTask> taskList = toDoTaskManager.getAllTasks(null);
		taskList.clear();
		
		TreeItem<String> taskTreeRoot = new TreeItem<>();
		
		for(ToDoTask task : taskList) {
			TreeItem<String> taskDescription = new TreeItem<>(task.getDescription());
			taskTreeRoot.getChildren().add(taskDescription);
		}
		
		taskTree.setRoot(taskTreeRoot);
	}
	
	public void updateDetailView(ToDoTask task) {
		taskLabel.setText(task.getDescription());
	}
	
		
}
