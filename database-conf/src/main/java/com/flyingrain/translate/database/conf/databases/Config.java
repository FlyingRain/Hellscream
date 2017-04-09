package com.flyingrain.translate.database.conf.databases;

/**
 * Created by wally on 4/9/17.
 */
public class Config {
        private String userName;

        private  String password;

        private String url;

        private String driveClass;

        public Config() {
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDriveClass() {
            return driveClass;
        }

        public void setDriveClass(String driveClass) {
            this.driveClass = driveClass;
        }

}
