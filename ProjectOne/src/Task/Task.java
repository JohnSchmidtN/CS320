// John Schmidt
// CS-320
// October 10, 2026


package Task;

public class Task {
	
	private String _taskID;
	private String _taskName;
	private String _taskDescription;
	
	public Task(String id, String name, String description) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID Used");
		}
		
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name Used");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description Used");
		}
		
		_taskID = id;
		_taskName = name;
		_taskDescription = description;
	}
	
	public String GetID() {
		return _taskID;
	}
	
	public String GetTaskName() {
		return _taskName;
	}
	
	public String GetTaskDescription() {
		return _taskDescription;
	}
	
	public void SetTaskName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name Used");
		}
		_taskName = name;
	}
	
	public void SetTaskDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description Used");
		}
		_taskDescription = description;
	}
}