package by.htp.project.human_resource.entity;

import java.util.Date;

public class MessageBuilder {

	private int idmessage;
	private String name;
	private String email;
	private Date createdate;
	private String content;

	public MessageBuilder idmessage(final int idmessage) {
		this.idmessage = idmessage;
		return this;
	}

	public MessageBuilder name(final String name) {
		this.name = name;
		return this;
	}

	public MessageBuilder email(final String email) {
		this.email = email;
		return this;
	}

	public MessageBuilder createdate(final Date createdate) {
		this.createdate = createdate;
		return this;
	}

	public MessageBuilder content(final String content) {
		this.content = content;
		return this;
	}

	public Message build() {
		Message message = new Message();
		message.setIdmessage(idmessage);
		message.setName(name);
		message.setEmail(email);
		message.setCreatedate(createdate);
		message.setContent(content);
		return message;
	}
}
