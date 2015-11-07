package src.Chat;

public interface Chat {

	//private void getInput();
	
	public void appendUserMessage(String user, String msg);
	
	public void setUserName(String user);
	
	public String getUserName();
}
