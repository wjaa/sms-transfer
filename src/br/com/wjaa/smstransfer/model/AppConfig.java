package br.com.wjaa.smstransfer.model;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class AppConfig {

	private Boolean notifySmsAccept;
	private Boolean notifyExecuteAction;
	private Boolean activeSystemOnStart;
	
	
	public Boolean getNotifySmsAccept() {
		return notifySmsAccept;
	}
	public void setNotifySmsAccept(Boolean notifySmsAccept) {
		this.notifySmsAccept = notifySmsAccept;
	}
	public Boolean getNotifyExecuteAction() {
		return notifyExecuteAction;
	}
	public void setNotifyExecuteAction(Boolean notifyExecuteAction) {
		this.notifyExecuteAction = notifyExecuteAction;
	}
	public Boolean getActiveSystemOnStart() {
		return activeSystemOnStart;
	}
	public void setActiveSystemOnStart(Boolean activeSystemOnStart) {
		this.activeSystemOnStart = activeSystemOnStart;
	}
	
}
