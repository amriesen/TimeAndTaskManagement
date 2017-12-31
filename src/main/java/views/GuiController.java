package views;

import java.awt.TextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.jdo.PersistenceManager;
import javax.persistence.Persistence;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import model.ToDoTask;
import model.ToDoTaskManager;

public class GuiController implements Initializable {

	@FXML
	private TreeView<ToDoTask> taskTree;

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

	@FXML
	private GridPane detailsPane;
	
		
	private ToDoTaskManager toDoTaskManager;
	
	
	private ToDoTask activeTask;
	
	public GuiController(ToDoTaskManager manager) {
		this.toDoTaskManager = manager;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<ToDoTask> taskList = toDoTaskManager.getAllTasks(null);

		taskTree.setShowRoot(false);

		TreeItem<ToDoTask> taskTreeRoot = new TreeItem<>();

		for (ToDoTask task : taskList) {
			TreeItem<ToDoTask> taskDescription = new TreeItem<>(task);
			taskTreeRoot.getChildren().add(taskDescription);
		}

		taskTree.setRoot(taskTreeRoot);
		updateDetailView(taskList.get(1));

		taskTree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<ToDoTask>>() {

			@Override
			public void changed(ObservableValue<? extends TreeItem<ToDoTask>> observable, TreeItem<ToDoTask> oldValue,
					TreeItem<ToDoTask> newValue) {
					activeTask = newValue.getValue();
					updateDetailView(newValue.getValue());
			}
		});
		
		
		taskLabel.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				// Remove the label from view
				detailsPane.getChildren().remove(taskLabel);
				
				// Add new Textfield
				javafx.scene.control.TextField taskEditBox = new javafx.scene.control.TextField();
				taskEditBox.setText(taskLabel.getText());
				detailsPane.add(taskEditBox, 1, 0);
				taskEditBox.selectAll();
				taskEditBox.requestFocus();
				
				// Set Focus lost Event				
				taskEditBox.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						// Remove Text Field
						detailsPane.getChildren().remove(taskEditBox);
						
//						toDoTaskManager.updateTaskName(activeTask, taskEditBox);
						
						// Add new Label
						taskLabel.setText(taskEditBox.getText());
						detailsPane.add(taskLabel, 1, 0);							
					}
				});
			}
		});		
	}

	/**
	 * Method to update the Task Tree from the database.
	 */
	public void updateTaskTree() {

		List<ToDoTask> taskList = toDoTaskManager.getAllTasks(null);
		taskList.clear();

		TreeItem<ToDoTask> taskTreeRoot = new TreeItem<>();

		for (ToDoTask task : taskList) {
			TreeItem<ToDoTask> taskDescription = new TreeItem<>(task);
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

		taskLabel.setText(nullFilter(task.getDescription()));
		creationDateLabel.setText(nullFilter(task.getCreationDate()));
		dueDateLabel.setText(nullFilter(task.getDueDate()));
		catagoryLabel.setText(nullFilter(task.getCatagory()));
		priorityLabel.setText(nullFilter(task.getPriority()));
		detailsLabel.setText(nullFilter(task.getDetails()));
	}
	
	private String nullFilter(Object obj) {
		if (obj != null && obj.toString() != null && !obj.toString().isEmpty()) {
			return obj.toString();
		}
		else {
			return "N/A";
		}
	}
}
