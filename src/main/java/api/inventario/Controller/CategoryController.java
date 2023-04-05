package api.inventario.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.inventario.Model.Category;
import api.inventario.Service.CategoryService;

@RestController
@RequestMapping("/inventary")
@CrossOrigin(origins = "*")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ArrayList<Category>getCategory(){
		return this.categoryService.getCategory();
	}
	
	@PostMapping
	public Category saveCategory(@RequestBody Category category) {
		return this.categoryService.saveCategory(category);
	}
	
	@GetMapping(path= "/{id}")
	public Optional<Category> getCategoryById(@PathVariable("id") Long id){
		return this.categoryService.getById(id);
	}
	
	@PutMapping(path= "/{id}")
	public Category updateCategoryById(@RequestBody Category requets, @PathVariable("id") Long id) {
		return this.categoryService.updateById(requets, id);
	}
	
	@DeleteMapping(path= "/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		boolean ok=this.categoryService.deleteCategory(id);

		if(ok) {
			return "category with id"+id+"is deleted!";
		}else {
			return "ERROR!, we have a problem with delete in this"+id;
		}
	}
}
