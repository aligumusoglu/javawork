package com.aligumusoglu.javawork.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

/**
 * 
 * @author Ali Gümüşoğlu
 *
 */

//This class have base methods. 
public class BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void addMessage(String clientId, FacesMessage.Severity severity,
			String summary, String message)
	{
		FacesContext.getCurrentInstance().addMessage(clientId,
				new FacesMessage(severity, summary, message));
	}

	protected void addErrorMessage(String clientId, String summary,
			String message)
	{
		addMessage(clientId, FacesMessage.SEVERITY_ERROR, summary, message);
	}

	protected void addErrorMessage(String summary, String message)
	{
		addErrorMessage(null, summary, message);
	}

	protected void addErrorMessage(String message)
	{
		addErrorMessage("Hata!", message);
	}

	protected void addInfoMessage(String clientId, String summary,
			String message)
	{
		addMessage(clientId, FacesMessage.SEVERITY_INFO, summary, message);
	}

	protected void addInfoMessage(String summary, String message)
	{
		addInfoMessage(null, summary, message);
	}

	protected void addInfoMessage(String message)
	{
		addInfoMessage("Bilgi", message);
	}

	protected void addWarningMessage(String clientId, String summary,
			String message)
	{
		addMessage(clientId, FacesMessage.SEVERITY_WARN, summary, message);
	}

	protected void addWarningMessage(String summary, String message)

	{
		addWarningMessage(null, summary, message);
	}

	protected void addWarningMessage(String message)

	{
		addWarningMessage("Uyarı!", message);
	}

	protected void addSavedMessage()

	{
		addInfoMessage("Başarıyla Kaydedildi");
	}

	protected void addNotSaveMessage()

	{
		addErrorMessage("İşlem Kaydedilemedi!");
	}

	protected void addDeletedMessage()
	{
		addInfoMessage("Başarıyla Silindi");
	}

	protected void addNotDeletedMessage()
	{
		addErrorMessage("Silme İşlemi Başarısız!");
	}

	protected void update(String... ids) {
		RequestContext.getCurrentInstance().update(Arrays.asList(ids));
	}

	protected void updateGrowl() {
		update("growl");
	}

	protected void update(String id) {
		RequestContext.getCurrentInstance().update(id);
	}

	protected void showDialog(String dialogName) {
		executeJs("showDialog('" + dialogName + "');");
	}

	protected void hideDialog(String dialogName) {
		executeJs("hideDialog('" + dialogName + "');");
	}

	protected void executeJs(String js) {
		RequestContext.getCurrentInstance().execute(js);
	}

}
