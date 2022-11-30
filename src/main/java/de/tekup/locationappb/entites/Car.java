package de.tekup.locationappb.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@JsonIdentityInfo(property = "model",generator = ObjectIdGenerators.PropertyGenerator.class)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String serie;

    @Column
    private String model;

    @Column
    private double dayPrice;

    @Column
    private String imageUrl;

    @Column
    @CreationTimestamp
    private LocalDate createdCarDate;

    @Column
    @UpdateTimestamp
    private LocalDate updatedCarDate;

    @OneToMany(mappedBy = "car")
    private List<Location> locations;
}
