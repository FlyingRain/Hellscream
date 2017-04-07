package com.flyingrain.translate.database.conf;

import com.flyingrain.translate.database.conf.databases.DataBasePro;
import javafx.beans.property.ObjectProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/7/17.
 */
@Component
public class DataBaseDispatcher implements ApplicationContextAware,InitializingBean {

    private Logger logger = LoggerFactory.getLogger(DataBaseDispatcher.class);

    private DataBasePro dataBasePro;

    private  ApplicationContext applicationContext;

    @Autowired
    public DataBaseDispatcher(DataBasePro dataBasePro) {
        this.dataBasePro = dataBasePro;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String [] names = applicationContext.getBeanNamesForAnnotation(DataSource.class);
        Object o = applicationContext.getBean(names[0]);

    }
}
