package dao;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MyBeanRepo implements MyBeanDAO {
    private List<String> beans;

    @PostConstruct
    public void initBeansList() {
        beans = new ArrayList<>();
    }

    @Override
    public boolean createMyBean(String beanName) {
        if (beanName != null) {
            beans.add(beanName);
            return true;
        }
        return false;
    }

    public MyBeanRepo() {}
}
