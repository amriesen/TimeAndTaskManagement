package views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.ToDoTask;

public class TaskDetailController implements Initializable {

	@FXML
	Label taskLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void updateDetailView(ToDoTask task) {
		taskLabel.setText(task.getDescription());
	}
}
