
public abstract class AppointmentDecorator implements Appointment{

    protected Appointment appointment;

    public AppointmentDecorator(Appointment appointment){
        this.appointment = appointment;
    }
}