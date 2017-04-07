package com.flyingrain.translate.database.conf.databases;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/7/17.
 */
@Component
@ConfigurationProperties(prefix = "datasource")
public class DataBasePro {
    /**
     * 初始化list
     */
    private List<DataBaseConfg> dataBaseConfgs = new ArrayList<>();

    class DataBaseConfg{
        private String userName;
        private String datasourceName;
        private String url;
        private String password;
        private String driveClassName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getDatasourceName() {
            return datasourceName;
        }

        public void setDatasourceName(String datasourceName) {
            this.datasourceName = datasourceName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDriveClassName() {
            return driveClassName;
        }

        public void setDriveClassName(String driveClassName) {
            this.driveClassName = driveClassName;
        }
    }

    public List<DataBaseConfg> getDataBaseConfgs() {
        return dataBaseConfgs;
    }

    public void setDataBaseConfgs(List<DataBaseConfg> dataBaseConfgs) {
        this.dataBaseConfgs = dataBaseConfgs;
    }
}
