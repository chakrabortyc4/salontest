package SpringMy.Maven.db.enities;

// default package
// Generated May 11, 2018 12:05:26 PM by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name="category"
    ,catalog="salontest"
)
public class Category  implements java.io.Serializable {


     private Integer categoryId;
     private String categoryName;
    /* private Set<File> files = new HashSet<File>(0);*/

    public Category() {
    }

	
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
   /* public Category(String categoryName, Set<File> files) {
       this.categoryName = categoryName;
       this.files = files;
    }*/
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="category_id", unique=true, nullable=false)
    public Integer getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    @Column(name="category_name", nullable=false, length=45)
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="category")
    public Set<File> getFiles() {
        return this.files;
    }
    
    public void setFiles(Set<File> files) {
        this.files = files;
    }
*/



}


