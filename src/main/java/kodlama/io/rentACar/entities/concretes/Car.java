package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private int carId;

    @Column(name = "plate")
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state")
    private int state; // 1-Avaible, 2-Rented, 3-Maintenance

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}