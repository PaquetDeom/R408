package fr.paquet.echafaudage.element;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Entity
@Table(name = "REELT")
public class EltByName {

	@Id
	@GeneratedValue
	@Column(name = "ELELID")
	private long id = 0;

	@XStreamOmitField
	@Column(name = "ELELNA", length = 80)
	private String name = null;

	@XStreamOmitField
	@Enumerated(EnumType.STRING)
	private InstanciationElement intanc = null;

	public EltByName() {
		super();
	}

	public EltByName(String name, InstanciationElement instanc) {
		this();
		setName(name);
		setIntanc(instanc);
		
	}

	public InstanciationElement getIntanc() {
		return intanc;
	}

	private void setIntanc(InstanciationElement intanc) {
		this.intanc = intanc;
	}


	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

}
