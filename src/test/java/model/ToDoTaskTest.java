package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToDoTaskTest {
	
	@Test
	public void testConstructor() {
		ToDoTask task = new ToDoTask("Task Description");
		assertNotNull(task);
	}

}
