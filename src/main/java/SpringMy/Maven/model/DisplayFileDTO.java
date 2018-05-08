package SpringMy.Maven.model;

import java.util.Arrays;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class DisplayFileDTO {
	Integer fileId;
	String categoryname;
	String titel;
	String time;
	String position;
	private byte[] itemImage;
	public DisplayFileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	
	public DisplayFileDTO(Integer fileId, String categoryname, String titel, String time, String position,
			byte[] itemImage) {
		super();
		this.fileId = fileId;
		this.categoryname = categoryname;
		this.titel = titel;
		this.time = time;
		this.position = position;
		this.itemImage = itemImage;
	}





	public Integer getFileId() {
		return fileId;
	}


	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}


	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public byte[] getItemImage() {
		return itemImage;
	}
	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "DisplayFileDTO [categoryname=" + categoryname + ", titel=" + titel + ", time=" + time + ", position="
				+ position + ", itemImage=" + Arrays.toString(itemImage) + "]";
	}
	
	
	
}
