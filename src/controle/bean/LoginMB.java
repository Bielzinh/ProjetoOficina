package controle.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controle.util.JSFUtil;
import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB
{
	private boolean autenticado = false;
	private Usuario usuario = null;
	private Usuario user = new Usuario();
	private UsuarioDAO  dao = new UsuarioDAO();
	private String login;
	private String senha;
	
	
	
	public String retornar(){
		
		return"login.jsf";
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public UsuarioDAO getDao() {
		return dao;
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}


	
	
	
	
	public boolean isAutenticado()
	{
		return autenticado;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	
	
	public String acaoAutenticar()
	{
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario usuarioDoBanco = dao.lerPorLogin(this.getLogin());

		if (usuarioDoBanco == null)
		{
			JSFUtil.retornarMensagem(null, "Usuário não existe.");
			return "login.jsf";
		}
		else if (usuarioDoBanco.senhaCorreta(this.getSenha()))
		{
			// guardar o obteto usuário
			this.setUsuario(usuarioDoBanco);
			this.autenticado = true;

			return "Menu.jsf";
		

		
		
		}
		else
		{
			JSFUtil.retornarMensagem(null, "Senha inválida.");
			return "login.jsf";
			
		}

		
	}
	
	public String acaoSalvar() {
		this.dao.salvar(this.user);
		
	
		 
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados gravados com sucesso!", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "login.jsf";
	}
}
