import java.io.Serializable;

public class Task implements Serializable{
	
	private int id;
	private String title;
	private DueDate dueDate;
	private String status="To Do";
	private  String project;
	private Inputs inputs;
	
	// create constructor of Task
	Task(){
		dueDate=new DueDate();
		inputs=new Inputs();
	};
	
	// create constructor of Task with parameter
	Task(int id,String title,String project, DueDate dueDate) {
		
		this.title=title;
		this.project=project.toUpperCase();
		this.dueDate=dueDate;
	}
	
	// Getter for id
	public int getId() {
		return id;
	}

	// Setter for id
	public void setId(int id) {
		this.id = id;
	}

	// Getter for title
	public String getTitle() {	
		return this.title;
	} 

	// Setter for title
	public void setTitle(String title) {
		this.title=title;
	}

	// Getter for Due date
	public DueDate getDueDate() {
		return this.dueDate;
	}

	// Setter for due date
	public void setDueDate(DueDate dueDate) {
		this.dueDate=dueDate.setDue(inputs);
	}

	// Getter for status
	public String getStatus() {
		return this.status;
	}

	// Mark task as done
	public void markAsDone() {
		this.status="Done";
	}

	// Getter project
	public String getProject() {
		return project;
	}

	// Setter for project
	public void setProject(String project) {
		
		this.project = project.toUpperCase();
	}

	// Format Task to print
	public String toString() {
		
		return id +" Task Title is: "+title+" Project is: "+ project+" Due date of the Task is: "+dueDate.toString()+" Status of the task is: "+status;
	}
	
	// Compare two tasks
	public int compareTask(Task other) {
		
		return this.getDueDate().compareTo(other.getDueDate());
	}

	
	public String enterString() {
		String str=inputs.setInputsString();
		return str;
	}
	
	/*public void addProject() {
		System.out.println("Please enter a project of the task from the list or enter a new one: ");
		String project=enterString().trim();
		this.setProject(project);
	}*/ 
	
	// Add title to a task
	public void addTitle() {
		System.out.print("Pleaee enter a title of the task >>");
		String title=enterString().trim();
		this.setTitle(title);
	} 
	
	
	// Create new task without add project
	public Task createTaskWithoutProject(int id) {
		addTitle();
		setDueDate(dueDate);
		setId(id);
		return this;
	}
}
