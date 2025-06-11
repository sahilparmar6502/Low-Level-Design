
public class BloodTest extends AppointmentDecorator{

    public BloodTest(Appointment appointment){
        super(appointment);
    }

    public String getDescription(){
        return appointment.getDescription() + ", Blood Test";
    }

    public double getCost(){
        return appointment.getCost() + 200.0;
    }
}