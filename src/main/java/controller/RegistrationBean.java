package controller;

import dao.MyBeanDAO;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@ManagedBean(value = "registration")
@ViewScoped
public class RegistrationBean implements Serializable {

    @ManagedProperty(value = "#{myBeanDAO}")
    transient private MyBeanDAO myBeanDAO;
    @ManagedProperty(value = "#{beanName}")
    private String beanName;
    private String message;

    public void createBean() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            boolean opStatus = myBeanDAO.createMyBean(beanName);
            context.isValidationFailed();
            if (opStatus) {
                message = "Bean %s created".formatted(beanName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            message = "Error creating bean %s".formatted(beanName);
        }
    }

    public MyBeanDAO getMyBeanDAO() {
        return myBeanDAO;
    }

    public void setMyBeanDAO(MyBeanDAO myBeanDAO) {
        this.myBeanDAO = myBeanDAO;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
