package SpringMy.Maven.model;

public class ResponseDTO {
	
  private Boolean success;
  private Object data;
  private Error error;
  private String message;
  
public ResponseDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public ResponseDTO(Boolean success, Object data, Error error, String message) {
	super();
	this.success = success;
	this.data = data;
	this.error = error;
	this.message = message;
}

public Boolean getSuccess() {
	return success;
}

public void setSuccess(Boolean success) {
	this.success = success;
}

public Object getData() {
	return data;
}

public void setData(Object data) {
	this.data = data;
}

public Error getError() {
	return error;
}

public void setError(Error error) {
	this.error = error;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

@Override
public String toString() {
	return "ResponseDTO [success=" + success + ", data=" + data + ", error=" + error + ", message=" + message + "]";
}
  
}
