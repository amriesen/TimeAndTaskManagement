import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.VisitRecord;

public class DataBasePersistenceCheck {

	public static void main(String[] args) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("taskDatabase.odb");
		EntityManager entityManager = entityMangerFactory.createEntityManager();

		// entityManager.getTransaction().begin();
		//
		// VisitRecord visit = new VisitRecord();
		// visit.endWork();
		//
		// entityManager.persist(visit);
		// entityManager.getTransaction().commit();

		TypedQuery<VisitRecord> query = entityManager.createQuery("select t from VisitRecord t", VisitRecord.class);

		List<VisitRecord> taskList = query.getResultList();

		for (VisitRecord task : taskList) {
			System.out.println(task.getStartTime());
			// System.out.println("\t" + task.getDueDate() != null ? task.getDueDate() : "No
			// Date");
		}

		entityManager.close();
		entityMangerFactory.close();
	}

}
