
public class DoctorAppointment implements Appointment{

    public String getDescription(){
        return "Doctor Consultation";
    }

    public double getCost(){
        return 500.0;
    }
}