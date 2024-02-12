package com.pw.airbnb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pId")
    private Long id;
    @NotBlank
    private String propertyName;
    private String location;
    private Double price;
    private String description;
    private String category;
    private Integer guestCapacity;
    private Integer reviews;
    private String teaserImage;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_property_id", referencedColumnName = "pId")
    private List<PropertyImage> propertyImages;
}
