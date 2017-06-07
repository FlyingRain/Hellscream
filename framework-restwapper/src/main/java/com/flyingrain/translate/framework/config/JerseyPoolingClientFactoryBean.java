package com.flyingrain.translate.framework.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.apache.connector.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * FactoryBean提供了创建Bean的工厂方法，实际上返回的是getObject返回的对象
 * Created by wally on 4/6/17.
 */
@Service("jerseyClient")
public class JerseyPoolingClientFactoryBean implements FactoryBean<Client>, InitializingBean, DisposableBean {

    private Logger logger = LoggerFactory.getLogger(JerseyPoolingClientFactoryBean.class);
    /**
     * client实例，重量级实例每次创建都需要消耗实例，因此需要封装，采用资源池模式
     */
    private Client client;

    /**
     * jersey的配置实例
     */
    private ClientConfig clientConfig;

    /**
     * httpclient链接的最大链接数
     */
    private int maxLoad = 1000;

    /**
     * httpclient每个主机地址的并发数
     */
    private int defaultMaxPreRoute = 100;

    public JerseyPoolingClientFactoryBean() {

    }

    public JerseyPoolingClientFactoryBean(int maxLoad, int defaultMaxPreRoute) {
        this.maxLoad = maxLoad;
        this.defaultMaxPreRoute = defaultMaxPreRoute;
    }

    /**
     * 当Bean中有需要手动释放的资源时，可以实现disposableBean，来让容器在销毁Bean时做
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        if(null!=client){
            client.close();
        }
    }

    @Override
    public Client getObject() throws Exception {
        return client==null?ClientBuilder.newClient():client;
    }

    @Override
    public Class<?> getObjectType() {
        return (this.client == null ? Client.class : this.client.getClass());
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //没有配置，采用默认配置
        if (null == clientConfig) {
            logger.info("start to assemble default jerseyConfig...");
            clientConfig = new ClientConfig();
            final PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
            connectionManager.setMaxTotal(maxLoad);
            connectionManager.setDefaultMaxPerRoute(defaultMaxPreRoute);
            clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connectionManager);
        }
        client = ClientBuilder.newClient(clientConfig).register(JacksonJsonProvider.class);


    }
}
