package controller;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.el.ELContextEvent;
import javax.el.ELContextListener;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@ManagedBean(value = "ELBean")
@ViewScoped
public class ELBean {

    private String beanName;

    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance()
                .getApplication()
                .addELContextListener(new ELContextListener() {
                    @Override
                    public void contextCreated(ELContextEvent event) {
                        event.getELContext()
                                .getImportHandler()
                                .importClass(String.valueOf(this.getClass()));
                    }
                });
    }

    public void saveBeanName(String beanName) {
        this.beanName = beanName;
    }

    private Object evaluateEL(String elExpression, Class<?> clazz) {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        return application.evaluateExpressionGet(context, elExpression, clazz);
    }

    public void saveByELEvaluation() {
        beanName = (String) evaluateEL("#{beanName.value}", String.class);
    }


    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
