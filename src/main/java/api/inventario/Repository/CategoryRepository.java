package api.inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.inventario.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
