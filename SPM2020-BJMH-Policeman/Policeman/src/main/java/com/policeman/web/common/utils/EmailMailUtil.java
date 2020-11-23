package com.policeman.web.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @author amrengp
 * 发送邮件
 */
@org.springframework.stereotype.Service("emailMailUtil")
@Slf4j
public class EmailMailUtil {

    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String form;

	public static void main(String[] args) {
		String model = "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\"content=\"text/html; charset=gb2312\"><title>异常闸机数据</title></head></body></html>";

	}


	/**
	 * 
	 * @param title 标题
	 * @param content 内容
	 * @param to_user_email 收件人列表
	 */
	public void doSend(String title,String content,List<String> to_user_email) {
        MimeMessage message = mailSender.createMimeMessage();
        log.info("开始给发送邮件:{}",content);
        if(StringUtils.isBlank(content)){
            log.info("邮件内容为空！不发送");
            return;
        }
        try {
            if(to_user_email!=null && !to_user_email.isEmpty()){
                log.info("接收地址："+to_user_email.toArray());
                String[] array = to_user_email.toArray(new String[]{});
                //true表示需要创建一个multipart message
                MimeMessageHelper helper=new MimeMessageHelper(message,true);
                helper.setFrom(form);
                helper.setTo(array);
                helper.setSubject(title);
                helper.setText(content,true);
                mailSender.send(message);
                log.info("邮件发送成功："+to_user_email);
            }else {
                log.info("邮件发送地址为空！不发送");
            }
        }catch (Exception e){
            log.info("邮件发送失败",e);
        }
	}

}
