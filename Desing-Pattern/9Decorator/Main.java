
public class Main{
    public static void main(String args[]){

        Appointment appointment = new DoctorAppointment();
        System.out.println(appointment.getDescription() + " = " + appointment.getCost());

        appointment = new BloodTest(appointment);
        System.out.println(appointment.getDescription() + " = " + appointment.getCost());

        appointment = new XRay(appointment);
        System.out.println(appointment.getDescription() + " = " + appointment.getCost());
    }
}