package SpringMy.Maven.model;

public class CategoryCountMap {
	
	 private Integer category_id;
	 private Integer file_id;
	 
	 
	 public CategoryCountMap() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CategoryCountMap(Integer category_id, Integer file_id) {
		super();
		this.category_id = category_id;
		this.file_id = file_id;
	}


	public Integer getCategory_id() {
		return category_id;
	}


	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}


	public Integer getFile_id() {
		return file_id;
	}


	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}


	@Override
	public String toString() {
		return "CategoryCountMap [category_id=" + category_id + ", file_id=" + file_id + "]";
	}


	


	
	
	

}
