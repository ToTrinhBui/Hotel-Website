package hotel.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "Customer")
@Getter
@Setter
public class User {
	@Id
	private Integer id;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Birthday is required")
	private Date birthday; 
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotBlank(message = "Phonenumber is required")
	private String phone;
	
	@NotBlank(message = "Email is required")
	private String email;
	

	@NotBlank(message = "Username is required")
	private String username;

	@NotBlank(message = "Password is required")
	private String password;
}
