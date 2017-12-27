package views;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import model.ToDoTask;
import model.ToDoTaskManager;

public class GuiController implements Initializable {

	@FXML
	private TreeView<String> taskTree;

	@FXML
	private Label taskLabel;

	@FXML
	private Label creationDateLabel;

	@FXML
	private Label dueDateLabel;

	@FXML
	private Label catagoryLabel;

	@FXML
	private Label priorityLabel;

	@FXML
	private Label detailsLabel;

	@FXML
	private AnchorPane updateAnchorPane;

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
		updateDetailView(taskList.get(1));

	}

	/**
	 * Method to update the Task Tree from the database.
	 */
	public void updateTaskTree() {

		ToDoTaskManager toDoTaskManager = ToDoTaskManager.getInstance();
		List<ToDoTask> taskList = toDoTaskManager.getAllTasks(null);
		taskList.clear();

		TreeItem<String> taskTreeRoot = new TreeItem<>();

		for (ToDoTask task : taskList) {
			TreeItem<String> taskDescription = new TreeItem<>(task.getDescription());
			taskTreeRoot.getChildren().add(taskDescription);
		}

		taskTree.setRoot(taskTreeRoot);
	}

	/**
	 * Method which updates the GUI to display the full task object.
	 * 
	 * @param task
	 *            The task object to be displayed.
	 */
	public void updateDetailView(ToDoTask task) {

		taskLabel.setText(task.getDescription());
		creationDateLabel.setText(task.getCreationDate().toString());
		dueDateLabel.setText(task.getDueDate().toString());
		catagoryLabel.setText(task.getCatagory().toString());
		priorityLabel.setText(task.getPriority().toString());
		detailsLabel.setText(task.getDetails());
	}
}
