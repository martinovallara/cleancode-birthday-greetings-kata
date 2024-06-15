package cleancode;

public final class EMailMessage {

    private final String recipient;
    private final String body;
    private final String subject;

    public EMailMessage(Employee employee) {
        this.recipient = employee.getEmail();
        this.body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
        this.subject = "Happy Birthday!";
    }

    public String getRecipient() {
        return recipient;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }
}