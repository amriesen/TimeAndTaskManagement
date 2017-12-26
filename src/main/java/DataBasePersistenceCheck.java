import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ToDoTask;

public class DataBasePersistenceCheck {

	public static void main(String[] args) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("taskDatabase.odb"); 
		EntityManager entityManager = entityMangerFactory.createEntityManager();
//		
//		entityManager.getTransaction().begin();
//		
//		ToDoTask task = new ToDoTask("First Task", Timestamp.valueOf("1995-04-25 20:30:00"), ToDoTask.TaskCatagory.GENERAL, ToDoTask.TaskPriority.CRITIAL, "This will eventually work.");
//		
//		entityManager.persist(task);
//		entityManager.getTransaction().commit();
		

		TypedQuery<ToDoTask> query = entityManager.createQuery("select t from ToDoTask t", ToDoTask.class);

		List<ToDoTask> taskList = query.getResultList();
		
		for (ToDoTask task : taskList) {
			System.out.println(task.getDescription());
			System.out.println("\t" + task.getDueDate() != null ? task.getDueDate() : "No Date");
		}
		
		entityManager.close();
		entityMangerFactory.close();
	}

}
