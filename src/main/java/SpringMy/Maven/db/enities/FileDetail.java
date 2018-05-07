package SpringMy.Maven.db.enities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "file", catalog = "salontest")
public class FileDetail implements java.io.Serializable {

	private int fileId;	
	private Users users;
	private String titel;
	private byte[] file;
	private Date upload_time;
	private Category category;
	private String originalFileName;
	private String categoryIndex;

	

	public FileDetail() {
	}

	public FileDetail(int fileId, Category category, Users users, String titel, byte[] file, Date upload_time, String originalFileName,String categoryIndex) {
		this.fileId = fileId;
		this.category = category;
		this.users = users;
		this.titel = titel;
		this.file = file;
		this.upload_time= upload_time;
		this.originalFileName=originalFileName;
		this.categoryIndex = categoryIndex;
	}

	@Id
	@Column(name = "file_id", unique = true, nullable = false)
	public int getFileId() {
		return this.fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category Category) {
		this.category = Category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "titel", nullable = false, length = 200)
	public String getTitel() {
		return this.titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	@Column(name = "original_file_name", nullable = false, length = 200)
	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	@Lob
	@Column(name = "file", nullable = false)
	@Basic(fetch=FetchType.LAZY)
	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upload_time", nullable = false, length = 19)
	public Date getUpload_time() {
		return upload_time;
	}

	public void setUpload_time(Date upload_time) {
		this.upload_time = upload_time;
	}

	@Column(name = "category_index", nullable = false, length = 45)
	public String getCategoryIndex() {
		return categoryIndex;
	}

	public void setCategoryIndex(String categoryIndex) {
		this.categoryIndex = categoryIndex;
	}

	@Override
	public String toString() {
		return "FileDetail [fileId=" + fileId + ", users=" + users + ", titel=" + titel + ", file="
				+ Arrays.toString(file) + ", upload_time=" + upload_time + ", category=" + category
				+ ", originalFileName=" + originalFileName + ", categoryIndex=" + categoryIndex + "]";
	}
	
	

}

