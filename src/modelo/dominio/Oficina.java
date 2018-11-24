package modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_oficina")
public class Oficina {
	
	@Id
	@GeneratedValue(generator = "OFICINA", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "OFICINA", allocationSize = 1, sequenceName = "SEQ_OFICINA")
	private Integer codigo;
	
	private String tiposervico;
	private float valorservico;
	
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTiposervico() {
		return tiposervico;
	}
	public void setTiposervico(String tiposervico) {
		this.tiposervico = tiposervico;
	}
	public float getValorservico() {
		return valorservico;
	}
	public void setValorservico(float valorservico) {
		this.valorservico = valorservico;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oficina other = (Oficina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Oficina [codigo=" + codigo + ", tiposervico=" + tiposervico + ", valorservico=" + valorservico + "]";
	}
	
	
	

}
