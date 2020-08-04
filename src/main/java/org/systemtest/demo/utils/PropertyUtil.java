package org.systemtest.demo.utils;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 12589
 */
public class PropertyUtil {
    public static Properties getProperty(Properties properties)  {
        properties.setProperty("mail.debug","true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.host", JavaMailUtil.mailHost);
        properties.setProperty("mail.transport.protocol", "smtp");
        return properties;
    }
}
