package api.inventario.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
    private static final long serialVerionUID=-4310027227752446841L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 60, nullable = false)
    private String name;
    @Column(name = "description", length = 60, nullable = false)
    private String description;

    public Category(){
    }

    public Category(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
    public static long getSerialverionuid() {
        return serialVerionUID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

   
    
}
