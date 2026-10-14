// John Schmidt
// CS-320
// October 10, 2026

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

class TaskServiceTest {

	
	
	
	@Test
	void testGetters() {
		var taskService = new TaskService();
		assertTrue(taskService.GetTaskCount() == 0);
		assertTrue(taskService.GetTaskCount() != 1);
		assertTrue(taskService.GetTaskList().isEmpty());
		taskService.PrintTaskList();
	}
	
	@Test
	void testAddTaskToTaskList() {
		TaskService taskService = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.AddTask(null, "Task Description");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.AddTask("TaskName", null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.AddTask("THIS IS TO TESK A NAME THAT IS TOO LONG", "Task Description");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.AddTask("TaskName", "THIS IS TO TEST FOR A DESCRIPTION THAT IS TOO LONG" + 
								"WHICH WOULD CAUSE AN ERROR");
		});
		
		taskService.AddTask("TaskName", "Task Description");
		assertTrue(taskService.GetTaskCount() == 1);
		assertTrue(!taskService.GetTaskList().isEmpty());
		taskService.PrintTaskList();
	}
	
	@Test
	void testRemoveTaskSuccessful() {
		TaskService taskService = new TaskService();
		taskService.AddTask("Task to Remove", "Description");
		assertEquals(1, taskService.GetTaskCount());
		
		String id = taskService.GetTaskList().get(0).GetID();
		taskService.RemoveTask(id);
		
		assertEquals(0, taskService.GetTaskCount());
		assertTrue(taskService.GetTaskList().isEmpty());
	}

	@Test
	void testRemoveTaskNotFound() {
		TaskService taskService = new TaskService();
		taskService.AddTask("Existing Task", "Description");
		
		// ID does not exist in list
		taskService.RemoveTask("999999999");
		assertEquals(1, taskService.GetTaskCount());
	}

	@Test
	void testRemoveTaskEmptyList() {
		TaskService taskService = new TaskService();
		// Covers _taskList.isEmpty() branch
		taskService.RemoveTask("12345");
		assertEquals(0, taskService.GetTaskCount());
	}

	
	@Test
	void testUpdateTask() {
		var taskService = new TaskService();
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask(null, "update", 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask("1234567", null, 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask("1234567", "update", -1);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask("123456789123", "update", 0);
		});
		
		taskService.UpdateTask("1234567", "update", 1);
		
		taskService.AddTask("New Task", "Description of New Task");
		Task task = taskService.GetTaskList().elementAt(0);
		
		taskService.UpdateTask(task.GetID(), "update", 0);
		
		taskService.UpdateTask("1234567",  "Name", 1);
		
		taskService.UpdateTask(task.GetID(), "New Task Name", 1);
		assertEquals("New Task Name", taskService.GetTaskList().elementAt(0).GetTaskName());
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask(task.GetID(), "THIS IS A NAME THAT IS TOO LONG FOR TESTING", 1);
		});
		
		taskService.UpdateTask(task.GetID(), "THIS IS THE UPDATED DESCRIPTION", 2);
		assertEquals("THIS IS THE UPDATED DESCRIPTION", taskService.GetTaskList().elementAt(0).GetTaskDescription());
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			taskService.UpdateTask(task.GetID(), "THIS IS A DESCRIPTION THAT IS TOO LONG FOR TESTING SO THAT" + 
									"THE SYSTEM WILL THROW AND ERROR SHOWING THAT IT IS TOO LONG", 2);
		});
	}
	
	@Test
	void testGenerateUniqueID() {
		var taskService = new TaskService();
		String str = taskService.GenerateUniqueID();
		int t = Integer.parseInt(str);
		assertTrue(t >= 0 && t < 1000000000);
	}
}