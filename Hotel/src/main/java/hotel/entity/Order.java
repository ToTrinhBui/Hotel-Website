package hotel.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "Room_Order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date createAt;
	
	@NotBlank(message = "check in is required")
	private Date checkIn;
	
	@NotBlank(message = "check out is required")
	private Date checkOut;
	
	@NotBlank(message = "id_room is required")
	private int id_room;
	
	@NotBlank(message = "id_customer is required")
	private int id_customer;
	
	@NotBlank(message = "amount is required")
	private long amount;
	

	@PrePersist
	void createAt() {
		this.createAt = new Date();
	}
}