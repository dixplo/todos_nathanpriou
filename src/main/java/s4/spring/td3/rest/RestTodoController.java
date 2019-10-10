package s4.spring.td3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s4.spring.td3.models.Todo;
import s4.spring.td3.repositories.TodoRepository;

@RestController
@RequestMapping("/rest/todo")
public class RestTodoController {
	@Autowired
	private TodoRepository repo;
	
	@GetMapping("")
	public @ResponseBody List<Todo> read(){
		return repo.findAll();
	}
	
	@PostMapping("create")
	public @ResponseBody Todo create(@RequestBody Todo todo) {
		repo.save(todo);
		return todo;
	}
}
