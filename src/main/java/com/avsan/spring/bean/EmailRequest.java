package com.avsan.spring.bean;


/**
 * @author MitaliChoudhary
 * @Date   28-Apr-2018
 * @Emp Id 103
 */

public class EmailRequest {

	private String  templateName;
	private String name;
	private String to;
	private String cc;
	private String bcc;    
	private String ísAttachment;
	
	
	
	public EmailRequest() {
		super();
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getÍsAttachment() {
		return ísAttachment;
	}
	public void setÍsAttachment(String ísAttachment) {
		this.ísAttachment = ísAttachment;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	@Override
	public String toString() {
		return "EmailRequest [templateName=" + templateName + ", name=" + name + ", to=" + to + ", cc=" + cc + ", bcc="
				+ bcc + ", ísAttachment=" + ísAttachment + "]";
	}

}
