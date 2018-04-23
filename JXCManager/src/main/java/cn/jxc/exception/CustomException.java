package cn.jxc.exception;

/**
 * 自定义异常
 * @author LXQ 2018/4/24
 *
 */
public class CustomException extends Exception {
	
	private String message;

	public CustomException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
