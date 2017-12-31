import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.ToDoTaskManager;
import views.GuiController;

public class StartApplicationGUI extends Application {

	public static void main(String[] args) {	
		launch(args);
	}

	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("taskDatabase.odb");

		
		FXMLLoader resourceLoader = new FXMLLoader(getClass().getResource("views/MainView.fxml"));
		resourceLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				if (param.equals(GuiController.class)){
					return new GuiController(new ToDoTaskManager(entityMangerFactory.createEntityManager()));
				}
				return null;
			}
		});
		BorderPane root = resourceLoader.load();
		
		primaryStage.setTitle("Task Manager");
		primaryStage.setScene(new Scene(root, 700, 500));
		primaryStage.show();
	}
	
	
	@Override
	public void stop() throws Exception {
//		 entityManager.close();
//		 entityMangerFactory.close();
		super.stop();
	}
}
