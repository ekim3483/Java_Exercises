import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appointment implements Serializable {
    private String appointmentType;
    private LocalDate date;
    private LocalTime time;

    public Appointment (String appointmentType, LocalDate date, LocalTime time) {
        this.appointmentType = appointmentType;
        this.date = date;
        this.time = time;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public LocalDate getAppointmentDate() {
        return date;
    }

    public LocalTime getAppointmentTime() {
        return time;
    }



    @Override
    public String toString() {
        return "Appointment: " + this.date + " at " + this.time +
                "\nAppointment Type: " + this.appointmentType;
    }
}