package s4.spring.td3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;
import s4.spring.td3.models.Todo;
import s4.spring.td3.repositories.TodoRepository;

@Controller
public class TestController {

	@Autowired
	private VueJS vue;
	
	@Autowired
	private TodoRepository repo;

	
	@RequestMapping("/todo/")
	public String indexTodos(ModelMap model){
		List<Todo> todos=repo.findAll();
		vue.addData("items",todos);
		vue.addData("dialog",false);
		vue.addData("snackbar",false);
		vue.addData("message");
		vue.addDataRaw("Todo","{label:'',description:'',poids:'',avancement:''}");
		vue.addMethod("addTodo", "let self=this;"+Http.post("/rest/todo/create", "this.Todo", "self.dialog=false;"
				+ "self.message='Todo ajouté ';"
				+ "self.snackbar=true;"
				+ "self.items.push(response.data);self.orga={};"));
		vue.addMethod("deleteTodo", 
				"let self=this;let $='';"+Http.delete("'/rest/todo/'+item.id+$","self.message=response.data;"
						+ "self.snackbar=true;"
						+ "self.items.splice(index,1);"),"item","index");
		model.put("vue", vue);
		return "spa";
	}
}







