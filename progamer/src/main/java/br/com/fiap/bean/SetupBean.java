package br.com.fiap.bean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;

@Named
@RequestScoped
public class SetupBean {

	private Setup setup = new Setup();
	
	@Inject
	private SetupDao dao;
	
	private UploadedFile image;
	
	public String save() throws IOException {
		
		ServletContext servletContext = (ServletContext) FacesContext
											.getCurrentInstance()
											.getExternalContext()
											.getContext();
		String path = servletContext.getRealPath("/");
		
		FileOutputStream out = 
				new FileOutputStream(path + "\\images\\setups\\" + image.getFileName());
		out.write(image.getContent());
		out.close();
		
		setup.setImagePath("\\images\\setups\\" + image.getFileName());
		dao.insert(setup);
		
		mostrarMensagem("Setup cadastrado com sucesso");
		
		return "setups?faces-redirect=true";
	}

	private void mostrarMensagem(String msg) {
		FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getFlash()
			.setKeepMessages(true);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage(msg));
	}
	
	public List<Setup> getSetups(){
		return dao.list();
	}
	
	public String remove(Setup setup) {
		dao.delete(setup);
		mostrarMensagem("Setup apagado com sucesso");
		return "setups?faces-redirect=true";
	}
	
	public void update() {
		dao.update(setup);
		mostrarMensagem("Setup atualizado com sucesso");
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

}
