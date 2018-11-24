package controle.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import modelo.dao.OficinaDAO;
import modelo.dominio.Oficina;

@RequestScoped
@ManagedBean(name="oficinaMB")
public class OficinaMB {
	
	// receber o código via <f:param >
	@ManagedProperty("#{param.codParam}")
	private String codParam;
	private OficinaDAO  dao = new OficinaDAO();
	private Oficina oficina = new Oficina();
	private List<Oficina> oficinas = null;
    
	
	
	public List<Oficina> getOficinas() {

		if (this.oficinas == null)
			this.oficinas = this.dao.lerTodos();

		return oficinas;
	}

	
	
	
	
	
	
	public String getCodParam() {
		return codParam;
	}


	public void setCodParam(String codParam) {
		this.codParam = codParam;
	}


	public OficinaDAO getDao() {
		return dao;
	}


	public void setDao(OficinaDAO dao) {
		this.dao = dao;
	}


	public Oficina getOficina() {
		return oficina;
	}


	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}


	public void lerOficina() {

		if (codParam != null) {
			try {
				Integer id = Integer.parseInt(this.codParam);
				this.oficina = this.dao.lerPorId(id);
			} catch (Exception e) {
			}
		}
	}
	
	
	public String acaoAbrirAlteracao(Integer id) {

		this.oficina = this.dao.lerPorId(id);


		return "Menu.jsf";
	}

	

	public String acaoExcluir(Integer id) {

		this.oficina = this.dao.lerPorId(id);

		this.dao.excluir(this.oficina);
		
		


		return acaoListar();
		
		
	}
	
	
	public String acaoListar() {
		return "Menu.jsf?faces-redirect=true";
	}
	
	
	public String acaoSalvar() {

		this.dao.salvar(this.oficina);

		return acaoListar();
	}
	
	

}
