package api.inventario.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.inventario.Model.Category;
import api.inventario.Repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public ArrayList<Category> getCategory(){
		return (ArrayList<Category>) categoryRepository.findAll();
	}
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Optional<Category> getById(Long id){
		return categoryRepository.findById(id);
	}
	
	public Category updateById(Category request, Long id ){
		Category category=categoryRepository.findById(id).get();
		category.setName(request.getName());
		category.setDescription(request.getDescription());
		return category;
	}
	public Boolean deleteCategory (Long id) {
		try {
			categoryRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
