// package com.example.bus_reservation_system.entity;
// import com.fasterxml.jackson.annotation.JsonBackReference;

// import jakarta.persistence.*;
// import lombok.Data;

// @Entity
// @Data
// public class BusScheduleDays {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "bus_schedule_id", nullable = false)
//     private BusSchedule busSchedule;

//     @ManyToOne
//     @JoinColumn(nullable = false,name = "route_id")
//     @JsonBackReference(value = "BusSchedule-Route") 
//     private Route route;

//     @Column(name = "day_of_week", nullable = false)
//     private String dayOfWeek;
// }


package com.example.bus_reservation_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
public class BusScheduleDays {

    @Embeddable
    public static class BusScheduleDaysId implements Serializable {
        @Column(name = "bus_schedule_id", nullable = false)
        private Long busSchedule;

        @Column(nullable = false)
        private String dayOfWeek;

        // Default constructor
        public BusScheduleDaysId() {}

        // Constructor
        public BusScheduleDaysId(Long busSchedule, String dayOfWeek) {
            this.busSchedule = busSchedule;
            this.dayOfWeek = dayOfWeek;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BusScheduleDaysId)) return false;
            BusScheduleDaysId that = (BusScheduleDaysId) o;
            return busSchedule.equals(that.busSchedule) && dayOfWeek.equals(that.dayOfWeek);
        }

        @Override
        public int hashCode() {
            return Objects.hash(busSchedule, dayOfWeek);
        }
    }

    @EmbeddedId
    private BusScheduleDaysId id;

    @ManyToOne
    @MapsId("busSchedule")  // Map the busSchedule field to the embedded ID
    @JoinColumn(name = "bus_schedule_id", nullable = false)
    private BusSchedule busSchedule;

    @ManyToOne
    @JoinColumn(nullable = false, name = "route_id")
    @JsonBackReference(value = "BusSchedule-Route")
    private Route route;

    // Other fields, getters, and setters as needed
}


