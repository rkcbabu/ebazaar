/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.util;

import java.util.Map;
import mum.pm.ebazaar.domain.Result;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Chaulagai
 */
public class Utils {

    public static String myfinance(String ccNo, String exptDate, String cvvNo, double balance, Map<String, String> params) {
        // we will add encryption of data here. 
        ccNo = DigestUtils.md5DigestAsHex(ccNo.getBytes());
        String url = "http://localhost:8080/myfinance/process/" + ccNo + "/" + exptDate + "/" + cvvNo + "/" + balance+
                "?fullname="+params.get("fullname")+"&emailid="+params.get("emailid")+"&billingaddress="+params.get("billingaddress");
        System.err.println(url);
        RestTemplate restTemplate = new RestTemplate();
        Result result = restTemplate.getForObject(url, Result.class);
        return result.getResult();
    }
    public static String deduct(String ccNo, String exptDate, String cvvNo, double balance) {
        // we will add encryption of data here. 
        ccNo = DigestUtils.md5DigestAsHex(ccNo.getBytes());
        String url = "http://localhost:8080/mycard/deduct/" + ccNo + "/" + exptDate + "/" + cvvNo + "/" + balance;
        RestTemplate restTemplate = new RestTemplate();
        Result result = restTemplate.getForObject(url, Result.class);
        return result.getResult();
    }

    public static String isValid(String ccNo, String exptDate, String cvvNo, double balance) {
        // we will add encryption of data here. 
        ccNo = DigestUtils.md5DigestAsHex(ccNo.getBytes());
        String url = "http://localhost:8080/mycard/validate/" + ccNo + "/" + exptDate + "/" + cvvNo + "/" + balance;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        Result result = restTemplate.getForObject(url, Result.class);
        return result.getResult();

        // research works ; 
        //        String url = "http://localhost:8080/mycard/validate/"+ccNo+"/"+exptDate+"/"+cvvNo+"/"+balance; 
//        System.out.println(url);
//        Map<String, String> vars = new HashMap<String, String>();
//        vars.put("ccNo", "4024007182706563");
//        vars.put("exptDate", "2017-01-03");
//        vars.put("cvvNo", "549");
//        vars.put("balance", "100.00");
//        RestTemplate restTemplate = new RestTemplate();
//        Result result = restTemplate.getForObject(url, Result.class);
//        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
//        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
//        Result result = restTemplate.postForObject("http://localhost:8080/mycard/validate/", request, Result.class, vars);
        //more details : http://www.thespringriver.com/simple-example-of-java-encryption-decryption/
//        try {
//            System.out.println(EncryptionUtil.decrypt(EncryptionUtil.encrypt(ccNo)));
//        } catch (NoSuchPaddingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (GeneralSecurityException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
