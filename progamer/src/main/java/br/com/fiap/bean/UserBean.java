package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;

@Named
@RequestScoped
public class UserBean {

	private User user = new User();
	
	//injeção de dependencia
	//CDI
	@Inject
	private UserDao dao;
	
	public String save(){
		
		dao.insert(user);
		
		mostrarMensagem();
		
		return "login?faces-redirect=true";
	}

	private void mostrarMensagem() {
		FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getFlash()
			.setKeepMessages(true);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Usuário cadastrado"));
	}
	
	public List<User> getUsers(){
		return dao.list();
	}
	
	public String login() {
		
		if (dao.exist(user)) {
			FacesContext	
				.getCurrentInstance()
				.getExternalContext()
				.getSessionMap()
				.put("user", user);
			
			return "setups";
		}
		
		FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getFlash()
			.setKeepMessages(true);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Login inválido"));
		
		return "login?faces-redirect=true";
		
	}
	
	public String logout() {
		FacesContext	
			.getCurrentInstance()
			.getExternalContext()
			.getSessionMap()
			.remove("user");
		
		return "login?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	


}
