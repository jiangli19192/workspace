package com.zjl.study.springboot;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class InvokeRestTest {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws JSONException {
		System.out.println("start test...");
		// doTest1();
		// doTest2();
		doTest3();
	}

	// 使用http连接调用CXF rest风格的web服务
	private static void doTest1() {
		try {
			String base = "http://dcsc.lenovo.com";// "http://localhost/pm/api";//http://192.168.0.100/pm/api/
			String authPath = base
					+ "/rest/authorization/auth/zongcai/764275/1000";
			HttpURLConnection conn = (HttpURLConnection) new URL(authPath)
					.openConnection();
			conn.setRequestProperty("Accept", "application/json");
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");

			int code = conn.getResponseCode();
			// 调用web服务
			if (code == 200) {
				InputStream inStream1 = conn.getInputStream();
				String jsonResult = getResponseString(inStream1);
				System.out.println(jsonResult);
				// 解析返回的json
				JSONObject jObj = new JSONObject(jsonResult);
				String personId = jObj.getJSONObject("Response").getString(
						"personId");
				String sessionId = jObj.getJSONObject("Response").getString(
						"sessionid");
				String path = base + "/rest/businesses/person/" + personId
						+ "/member";
				URL url = new URL(path);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("sessionId", sessionId);
				conn.setRequestProperty("personId", personId);
				conn.setConnectTimeout(5000);
				conn.setRequestMethod("GET");
				// 调用web服务
				if (conn.getResponseCode() == 200) {
					InputStream inStream = conn.getInputStream();
					jsonResult = getResponseString(inStream);
					System.out.println(jsonResult);
					JSONArray array = new JSONObject(jsonResult)
							.getJSONObject("Response")
							.getJSONObject("business")
							.getJSONArray("businessList");
					for (int i = 0; i < array.length(); i++) {
						System.out.println(" id:"
								+ array.getJSONObject(i).getInt("businessId"));
						System.out.println(" name:"
								+ array.getJSONObject(i).getString(
										"businessName"));
						System.out.println(" desc:"
								+ array.getJSONObject(i).getString(
										"businessDesc"));
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * 初始化RestTemplate，RestTemplate会默认添加HttpMessageConverter
	 * 添加的StringHttpMessageConverter非UTF-8 所以先要移除原有的StringHttpMessageConverter，
	 * 再添加一个字符集为UTF-8的StringHttpMessageConvert
	 */
	private static void resetCnMessageConverter(RestTemplate restTemplate) {
		List<HttpMessageConverter<?>> converterList = restTemplate
				.getMessageConverters();
		HttpMessageConverter<?> converterTarget = null;
		for (HttpMessageConverter<?> item : converterList) {
			if (item.getClass() == StringHttpMessageConverter.class) {
				converterTarget = item;
				break;
			}
		}

		if (converterTarget != null) {
			converterList.remove(converterTarget);
		}
		HttpMessageConverter<?> converter = new StringHttpMessageConverter(
				StandardCharsets.UTF_8);
		converterList.add(converter);
	}

	// 使用spring RestTemplate调用spring mvc rest web服务
	private static void doTest3() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String encodedToken = "Basic "
				+ Base64.encodeBase64String("zongcai:111111".getBytes());
		headers.set("Authorization", encodedToken);

		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		RestTemplate restTemplate = new RestTemplate();
		// 解决中文乱码问题
		resetCnMessageConverter(restTemplate);
		String serviceBase = "http://localhost/pm/rest/v1/project/{projectId}/workplan";
		String resourcePath = "/task/{taskId}";
		ResponseEntity<String> loginResponse = restTemplate.exchange(
				serviceBase + resourcePath, HttpMethod.GET, entity,
				String.class, "60838", "1000");
		if (loginResponse.getStatusCode() == HttpStatus.OK) {
			System.out.println(loginResponse.getBody());
		} else {
			System.out.println(loginResponse.getStatusCode());
		}
	}

	// 使用spring RestTemplate调用cxf REST web服务
	private static void doTest2() throws JSONException {

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		RestTemplate restTemplate = new RestTemplate();
		// 解决中文乱码问题
		resetCnMessageConverter(restTemplate);
		String serviceBase = "http://localhost/pm/api/rest/";
		String resourcePath = "authorization/auth/{userName}/{password}/{domainId}";
		ResponseEntity<String> loginResponse = restTemplate.exchange(
				serviceBase + resourcePath, HttpMethod.GET, entity,
				String.class, "zongcai", "764275", "1000");
		if (loginResponse.getStatusCode() == HttpStatus.OK) {
			String res = loginResponse.getBody();
			System.out.println(res);
			JSONObject jObj = new JSONObject(res);
			String personId = jObj.getJSONObject("Response").getString(
					"personId");
			String sessionId = jObj.getJSONObject("Response").getString(
					"sessionid");
			System.out.println(personId + " " + sessionId);

			resourcePath = "businesses/person/{personId}/member";
			headers.add("personId", personId);
			headers.add("sessionId", sessionId);
			entity = new HttpEntity<String>("", headers);
			loginResponse = restTemplate.exchange(serviceBase + resourcePath,
					HttpMethod.GET, entity, String.class, personId);
			if (loginResponse.getStatusCode() == HttpStatus.OK) {
				JSONArray array = new JSONObject(loginResponse.getBody())
						.getJSONObject("Response").getJSONObject("business")
						.getJSONArray("businessList");
				for (int i = 0; i < array.length(); i++) {
					System.out.println(" id:"
							+ array.getJSONObject(i).getInt("businessId"));
					System.out.println(" name:"
							+ array.getJSONObject(i).getString("businessName"));
					System.out.println(" desc:"
							+ array.getJSONObject(i).getString("businessDesc"));
				}
			}

			entity = new HttpEntity<String>("", headers);
			resourcePath = "workflow/participated/{userId}/{projectId}/{pageIndex}/{rowCountPerPage}";
			ResponseEntity<String> listResponse = restTemplate.exchange(
					serviceBase + resourcePath, HttpMethod.GET, entity,
					String.class, personId, "60825", 1, 20);
			System.out.println(listResponse.getBody());

			resourcePath = "workflow/participatedCount/{userId}/{projectId}";
			ResponseEntity<String> countResponse = restTemplate.exchange(
					serviceBase + resourcePath, HttpMethod.GET, entity,
					String.class, personId, "60825");
			if (countResponse.getStatusCode() == HttpStatus.OK) {
				System.out.println(countResponse.getBody());
			}

			resourcePath = "workflow/audit";
			JSONStringer s = new JSONStringer();
			s.object();
			s.key("userId").value(personId);
			s.key("flowId").value("123");
			s.key("auditComment").value("统一");
			s.key("auditPhoneNumber").value("12344323111");
			s.key("auditUserName").value("老何");
			s.key("auditResult").value("1");
			s.endObject();
			String requestBody = s.toString();
			List<MediaType> lstAccept = new ArrayList<MediaType>();
			lstAccept.add(MediaType.APPLICATION_JSON);
			headers.setAccept(lstAccept);
			entity = new HttpEntity<String>(requestBody, headers);
			countResponse = restTemplate.exchange(serviceBase + resourcePath,
					HttpMethod.PUT, entity, String.class);
			if (countResponse.getStatusCode() == HttpStatus.OK) {
				System.out.println(countResponse.getBody());
			}
		} else {
			System.out.println(loginResponse.getStatusCode());
		}
	}

	public static byte[] read(InputStream inStream) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outputStream.write(buffer);
		}
		inStream.close();
		return outputStream.toByteArray();
	}

	private static String getResponseString(InputStream inStream)
			throws Exception {
		byte[] data = read(inStream);
		String objectstring = new String(data);
		return objectstring;
	}
}
