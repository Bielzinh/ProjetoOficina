package modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "USUARIO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "USUARIO", allocationSize = 1, sequenceName = "SEQ_USUARIO")
	private Integer codigo;
	private String login;
	private String senha;
	private String nome;
	private String email;
	/* Incluindo novos campos 24-11-2018*/
	private String rua;
	private String bairro;
	private String cidade;
	private String cep;
	private Integer numero;
	private String uf;
	
	
	
	
	
	

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public boolean senhaCorreta(String senhaDigitada) {
		if (this.senha.equals(senhaDigitada))
			return true;
		else
			return false;
	}
	
	
	
	
	@Override
	public int hashCode() {
		if (this.codigo == null)
			return 0;

		return this.codigo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return this.login;
	}
	
	
	
	
	

}
