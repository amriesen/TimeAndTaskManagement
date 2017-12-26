import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ToDoTaskManager;

public class StartApplicationGUI extends Application {

	public static void main(String[] args) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("taskDatabase.odb");
		EntityManager entityManager = entityMangerFactory.createEntityManager();

		ToDoTaskManager toDoTaskManager = new ToDoTaskManager();

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = FXMLLoader.load(getClass().getResource("views/MainView.fxml"));
		javafx.scene.layout.GridPane details = FXMLLoader.load(getClass().getResource("views/TaskDetailView.fxml"));

		root.setCenter(details);

		// childrenList.setCenter(details);

		primaryStage.setTitle("Task Manager");
		primaryStage.setScene(new Scene(root, 700, 275));
		primaryStage.show();
	}
	// TODO create program close
	// entityManager.close();
	// entityMangerFactory.close();
}
