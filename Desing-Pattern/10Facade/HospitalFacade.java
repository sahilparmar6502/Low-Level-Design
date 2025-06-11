
class HospitalFacade{
    private AppointmentService appointmentService;
    private BillingService billingService;
    private MedicalService medicalService;

    public HospitalFacade(){
        appointmentService = new AppointmentService();
        billingService = new BillingService();
        medicalService = new MedicalService();
    }

    public void processNewPatient(String patient){
        System.out.println("\nProcessing new Patient"+patient);
        appointmentService.bookAppointment(patient);
        billingService.generateBill(patient);
        medicalService.assignDoctor(patient);
    }
}