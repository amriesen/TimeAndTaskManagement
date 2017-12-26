package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ToDoTaskManager {

	private static ToDoTaskManager instanse;
	
	@Deprecated
	private EntityManager entityMgr  = Persistence.createEntityManagerFactory("taskDatabase.odb").createEntityManager();
	
	@Deprecated
	public static ToDoTaskManager getInstance() {
		if (instanse == null) {
			instanse = new ToDoTaskManager();
		}
		return instanse;
	}
	
	
	public ToDoTaskManager() {
//		entityMgr.find(null, null);
	}
	
	public List<ToDoTask> getAllTasks(EntityManager entityManager){

			
		TypedQuery<ToDoTask> query = entityMgr.createQuery("select t from ToDoTask t", ToDoTask.class);
		return query.getResultList();
		
	}
	
	
}
