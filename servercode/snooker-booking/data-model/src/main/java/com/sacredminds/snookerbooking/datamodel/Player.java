package com.sacredminds.snookerbooking.datamodel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Player {

	@Id
	@GeneratedValue(generator = "player-sequence-generator")
    @GenericGenerator(
      name = "player-sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "player_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@Column
	private long playerId;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String phone;

	// bi-directional many-to-one association to Application
	@OneToMany(mappedBy = "player")
	@JsonIgnore
	private List<Booking> bookings;

}
