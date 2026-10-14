// John Schmidt
// CS-320
// October 10, 2026

package Task;

import java.util.Random;
import java.util.Vector;

public class TaskService {
	
	private Vector<Task> _taskList = new Vector<Task>();
	
	public Vector<Task> GetTaskList() {
		return _taskList;
	}
	
	public int GetTaskCount() {
		return _taskList.size();
	}
	
	public void PrintTaskList() {
		for (Task t : _taskList) {
			System.out.println("Task ID: " + t.GetID() + " Name: " + t.GetTaskName());
			System.out.println("Description: " + t.GetTaskDescription() + "\n");
		}
	}
	
	public void AddTask(String tName, String tDescription) {
		if (tName == null || tName.length() > 20) {
			throw new IllegalArgumentException("Invalid Length of Name");
		}
		if (tDescription == null || tDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Length of Description");
		}
		String newID = GenerateUniqueID();
		var newTask = new Task(newID, tName, tDescription);
		_taskList.add(newTask);
		System.out.println("Task " + newTask.GetTaskName() + " created new task sucessfully and added to list");
	}
	
	@SuppressWarnings("unused")
	private void AddTask(Task task) {
		_taskList.add(task);
	}
	
	@SuppressWarnings("unused")
	private void RemoveTask(Task task) {
		_taskList.remove(task);
	}
	
	public void RemoveTask(String id) {
		if (_taskList.isEmpty()) {
			System.out.print("There are no Tasks in the List to Remove");
			return;
		}
		
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID Used");
		}
		
		int index = -1;
		for (Task t : _taskList) {
			if (t.GetID().equals(id)) {
				index = _taskList.indexOf(t);
				break;
			}
		}
		
		if (index == -1) {
			System.out.println("No Task Found");
			return;
		}
		else {
			_taskList.remove(index);
			System.out.println("Task has been Removed for the List");
		}
	}
	
	public void UpdateTask(String id, String update, int selection) {
		if (id == null || id.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("Retry Request");
		}
		if (_taskList.isEmpty()) {
			System.out.println("No Tasks Currently in List");
			return;
		}
		
		int index = -1;
		for (Task t : _taskList) {
			if (t.GetID().equals(id)) {
				index = _taskList.indexOf(t);
				break;
			}
		}
		
		if (index == -1) {
			System.out.println("No Matching Task Found, Please Check ID");
			return;
		}
		
		Task updateTask = _taskList.get(index);
		
		switch (selection) {
		case 1:{
			updateTask.SetTaskName(update);
			break;
		}
		case 2:{
			updateTask.SetTaskDescription(update);
			break;
		}
		default:{
			System.out.println("No Updates Made, Check Request Type");
			break;
		}
		}
	}
	
	public String GenerateUniqueID() {
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		Vector<String> idList = new Vector<String>();
		for (Task t : _taskList) {
			idList.add(t.GetID());
		}
		
		while (idList.contains(uniqueID) || uniqueID.length() > 10) {
			newID = rand.nextInt(1000000000);
			uniqueID = Integer.toString(newID);
		}
		
		idList = null;
		return uniqueID;
	}
}
