package day08js;

import java.util.HashMap;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class hhhh {

	public static void main(String[] args) {
		send("18629208903");
		
		
	}	
		
		public static boolean send(String phoneNumber) {
	        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FfdxijaVSrdYjiaTLUe", "2HqKxLvDRvnetQ4xcASyMj0rRVRJ7m");
	        IAcsClient client = new DefaultAcsClient(profile);
	        CommonRequest request = new CommonRequest();
	        request.setMethod(MethodType.POST);
	        request.setDomain("dysmsapi.aliyuncs.com");
	        request.setVersion("2017-05-25");
	        request.setAction("SendSms");
	        request.putQueryParameter("RegionId", "cn-hangzhou");
	        request.putQueryParameter("PhoneNumbers", phoneNumber);
	        request.putQueryParameter("SignName", "好名字");
	        request.putQueryParameter("TemplateCode", "SMS_181201404");
	        //{"code":"134576"}
	        
	        request.putQueryParameter("TemplateParam", "{\"name\":\"一个好名字哎哟购买\"}");
	        try {
	            CommonResponse response = client.getCommonResponse(request);
	            System.out.println(response.getData());
	            String json = response.getData();
	            Gson g = new Gson();
	            HashMap result = g.fromJson(json, HashMap.class);
	            if("OK".equals(result.get("Message"))) {
	                return true;
	            }
	        } catch (ServerException e) {
	            e.printStackTrace();
	        } catch (ClientException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	

}
