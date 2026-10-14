// John Schmidt
// CS-320
// October 10, 2026

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {
	
	@Test
	void testTaskConstructor() {
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890A", "taskName", "taskDescription");
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890", "taskNameZYXWVUTSRQPONM", "taskDescription");
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890", "taskName", "taskDescriptiontaskDescriptiontaskDescriptiontaskDescriptiontaskDescription"
					+ "taskDescriptiontaskDescriptiontaskDescriptiontaskDescriptiontaskDescription");
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task(null, "taskName", "taskDescription");
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890", null, "taskDescription");
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			new Task("1234567890", "taskName", null);
		});
	}
	
	@Test
	void testTaskConstructorAndGetter() {
		Task task = new Task("1234567890", "Task Name", "Task Description");
		assertTrue(task.GetID().equals("1234567890"));
		assertTrue(task.GetTaskName().equals("Task Name"));
		assertTrue(task.GetTaskDescription().equals("Task Description"));
	}
	
	@Test
	void testTaskSetters() {
		Task task = new Task("1234567890", "Task name", "Task Description");
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			task.SetTaskName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			task.SetTaskName("TESTING NAME THAT IS TOO LONG TO BE VALID");
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			task.SetTaskDescription(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			task.SetTaskDescription("THIS TASK DESCRIPTION HAS TO BE TOO LONG IN ORDER TO TEST TO SEE IF THERE IS GOING TO BE AN ERROR THAT IS THROWN FOR IT");
		});
		
		task.SetTaskName("New Name");
		task.SetTaskDescription("New Description");
		assertTrue(task.GetTaskName().equals("New Name"));
		assertTrue(task.GetTaskDescription().equals("New Description"));
	}
}
