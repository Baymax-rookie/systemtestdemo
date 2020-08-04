package org.systemtest.demo.control;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.systemtest.demo.enums.ResponseEnum;
import org.systemtest.demo.utils.JavaMailUtil;
import org.systemtest.demo.utils.ResultData;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author 12589
 */
@RestController
public class MailController {
    Gson gson=new Gson();
    @PostMapping("/mailtest")
    public String doPost(String mail) throws IOException, MessagingException {
        String code= JavaMailUtil.postMail(mail);
        return gson.toJson(new ResultData<>(ResponseEnum.INFORM_SUCCESS,code));
    }

}
