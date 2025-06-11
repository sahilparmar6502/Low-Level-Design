
public class XRay extends AppointmentDecorator{

    public XRay(Appointment appointment){
        super(appointment);
    }

    public String getDescription(){
        return appointment.getDescription() + ", XRay";
    }

    public double getCost(){
        return appointment.getCost() + 300.0;
    }
}