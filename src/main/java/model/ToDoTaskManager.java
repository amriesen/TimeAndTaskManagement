package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ToDoTaskManager {

	
	private EntityManager entityMgr; 
		
	public ToDoTaskManager(EntityManager entityMgr) {
		this.entityMgr = entityMgr;
	}
	
	public List<ToDoTask> getAllTasks(EntityManager entityManager){

			
		TypedQuery<ToDoTask> query = entityMgr.createQuery("select t from ToDoTask t", ToDoTask.class);
		return query.getResultList();
		
	}
	
	
}
