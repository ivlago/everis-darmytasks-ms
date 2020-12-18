package Everis.everisdarmytasksms;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<Task> findAllTask() {
		return taskService.findAll();
	}
	
	@DeleteMapping(value="/{id}")
	public String deleteTask(@PathVariable (name="id") Long id) {
		if(taskService.getTask(id)!= null) {
			taskService.deleteById(id);
			return "Task Delete Successfully";
		} else {
			return "Not Task With This ID";
		}
	}

	 @GetMapping("/{id}")
	 public Task findTaskById(@PathVariable(name="id")Long id) {
	  return taskService.getTask(id);
	 }
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	 public Task saveTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	 }
	
	 @PutMapping(value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	 public Task updateTask(@RequestBody Task updateTask, @PathVariable(name="id") Long id) {
		Task findTask = taskService.getTask(id);
		if(findTask != null) {
			return taskService.updateTask(findTask, updateTask);
		} else {
			return null;
		}
	 }
	 
	 @GetMapping("/status/{state}")
	 public List<Task> findByState(@PathVariable(name="state")String state) {
	  return taskService.findByState(state);
	 }
}
