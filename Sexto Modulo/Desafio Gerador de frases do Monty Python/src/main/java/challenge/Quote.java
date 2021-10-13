package challenge;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "scripts")
@Getter
@Setter
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;

	@Column
	public String actor;

	@Column(name = "detail")
	public String quote;

}