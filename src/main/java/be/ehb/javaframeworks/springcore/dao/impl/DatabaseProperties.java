package be.ehb.javaframeworks.springcore.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("application.properties")
@Component
class DatabaseProperties {

    static String URL;
    static String USERNAME;
    static String PASSWORD;

    @Value("${url}")
    public void setURL(String URL) {
        DatabaseProperties.URL = URL;
    }

    @Value("${username}")
    public void setUSERNAME(String USERNAME) {
        DatabaseProperties.USERNAME = USERNAME;
    }

    @Value("${password}")
    public void setPASSWORD(String PASSWORD) {
        DatabaseProperties.PASSWORD = PASSWORD;
    }
}
