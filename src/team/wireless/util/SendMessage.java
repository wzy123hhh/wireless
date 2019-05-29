package team.wireless.util;

import java.util.Random;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient; 

public class SendMessage {
	
	private final String apiUrl = "https://sms_developer.zhenzikj.com";
	private final String appId = "101477";
	private final String appSecret = "ef247f1a-a8f1-4e5d-a3c0-32e784728e86";
	ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
	
	/**
	 * 发送验证短信
	 * @param tel手机号
	 * @return
	 */
	public JSONObject SendCode(String tel){  	
		try {
			
			JSONObject json = null;
			//生成6位验证码
			String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
			
			//发送短信
			String result = client.send(tel, "您的验证码为:" + verifyCode + "，该码有效期为5分钟，该码只能使用一次!");
			
			json = JSONObject.parseObject(result);
			if(json.getIntValue("code") != 0){//发送短信失败
				System.out.println("error");
				return null;
			}
			
			json = new JSONObject();
			json.put("mobile", tel);
			json.put("verifyCode", verifyCode);
			json.put("createTime", System.currentTimeMillis());
			
			
			
			System.out.println(json.toJSONString());
			return json ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 发送通知信息
	 * @param tel 电话
	 * @param content 内容
	 * @return
	 */
	public JSONObject SendNoticeMessage(String tel,String content) {
		JSONObject json = null;
		
		try {
			
			String result = client.send(tel, content);
			json = JSONObject.parseObject(result);
			if(json.getIntValue("code") != 0){//发送短信失败
				
				return null;
			}
			
			json = new JSONObject();
			json.put("mobile", tel);
			json.put("content", content);
			
			System.out.println(json.toString());
			
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public static void main(String[] args) {
		
		SendMessage sendSMSService =new SendMessage();
		
		sendSMSService.SendCode("17856002909");
	}

}
