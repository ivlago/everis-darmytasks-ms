package Everis.everisdarmytasksms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAll() {
		var allTask = taskRepository.findAll();
		return (List<Task>) allTask;
	}
	
	public void deleteById(Long taskId) {
		taskRepository.deleteById(taskId);
	}
	
	public Task getTask(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		if(!taskRepository.findById(id).isPresent()) {
			return null;
		} else {
			return task.get();			
		}
	}
	
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task updateTask(Task task, Task updateTask) {
		task.setTitle(updateTask.getTitle());
		task.setStatus(updateTask.getStatus());
		task.setDescription(updateTask.getDescription());
		System.out.print(task);
		taskRepository.save(task);
		return task;
	}
	
	public List<Task> findByState(String status) {
		List<Task> allTask = this.findAll();
		List<Task> statusTask = new ArrayList<Task>();
		for(Task task: allTask) {
			if(task.getStatus().equals(status)) {
				statusTask.add(task);
			};
		}
		return statusTask;
	}
}
