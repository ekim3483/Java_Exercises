import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pet implements Serializable {
    private String id;
    private String name;
    private String speciesOrBreed;
    private String age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;
    private List<Appointment> appointments;
    
    public Pet(String id, String name, String speciesOrBreed, String age, String ownerName, String contactInfo) {
        this.id = id;
        this.name = name;
        this.speciesOrBreed = speciesOrBreed;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate = LocalDate.now();
        this.appointments = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpeciesOrBreed() { return speciesOrBreed; }
    public String getAge() { return age; }
    public String getOwnerName() { return ownerName; }
    public String getContactInfo() { return contactInfo; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public List<Appointment> getAppointments() { return appointments; }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }
}