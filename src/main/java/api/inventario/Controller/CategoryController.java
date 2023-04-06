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
	
	
	
	@GetMapping(path= "/{id}")
	public Optional<Category> getCategoryById(@PathVariable("id") Long id){
		return this.categoryService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<Category> save(@RequestBody Category category){
		Category obj=categoryService.saveCategory(category);
		return new ResponseEntity<Category>(obj, HttpStatus.OK);
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
