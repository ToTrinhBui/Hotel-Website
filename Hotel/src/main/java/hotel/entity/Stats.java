package hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "stats")
@Getter
@Setter
public class Stats {
	
	@Column(name="id_room")
	@Id
	private Integer id_room;
	@NotNull
	@Column(name="name_room")
	private String name_room;
	@NotNull
	@Column(name="revenue")
	private Long revenue;
	@Override
	public String toString() {
		return "Stats [id_room=" + id_room + ", name_room=" + name_room + ", revenue=" + revenue + "]";
	}
}
