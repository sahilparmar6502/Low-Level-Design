
class AppointmentService{
    public void bookAppointment(String patient){
        System.out.println("Appointment booked for "+patient);
    }
};

class BillingService{
    public void generateBill(String patient){
        System.out.println("Bill generated for "+patient);
    }
};

class MedicalService{
    public void assignDoctor(String patient){
        System.out.println("Doctor assigned to "+patient);
    }
}