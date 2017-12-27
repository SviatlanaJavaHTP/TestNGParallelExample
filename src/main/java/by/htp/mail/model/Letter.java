package by.htp.mail.model;

import java.io.Serializable;

public class Letter implements Serializable{
	
	private final String TO = "sviatlana_zakharenka@gmail.com";
	private final String THEME = "[HTP_JAVA_TAT5] yandex test";
	private final String TEXT = "GitHub Message";

	private static final long serialVersionUID = -2662985421208187086L;
	
	private String recipient;
	private String sender;
	private String text;

	public Letter() {
		this.recipient = TO;
		this.sender = THEME;
		this.text = TEXT;
	}

	public Letter(String recipient, String sender, String text) {
		this.recipient = recipient;
		this.sender = sender;
		this.text = text;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Letter: recipient= " + recipient + ", sender= " + sender + ", text= " + text;
	}

}
