package domains.notification;

public class Notificacion {

    private String emailTo;
    private String emialFrom;
    private String message;
    private String nroCelularTo;
    private String nroCelularFrom;

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public void setEmialFrom(String emialFrom) {
        this.emialFrom = emialFrom;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNroCelularTo(String nroCelularTo) {
        this.nroCelularTo = nroCelularTo;
    }

    public void setNroCelularFrom(String nroCelularFrom) {
        this.nroCelularFrom = nroCelularFrom;
    }

    public String getMessage() {
        return message;
    }
}
