package com.innominds.team.utils;

import java.io.File;
import java.io.IOException;

import javax.security.sasl.AuthenticationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

/**
 * This class creates JSON object and create issue in JIRA through restful
 * service
 * 
 * @author Pradeep Reddy K
 *
 */
@SuppressWarnings("deprecation")
public class CreateIssueInJira {

	JsonParameters jsonParams = new JsonParameters();

	/**
	 * Forms JSON object for restful API input
	 * 
	 * @param failedMethodName
	 * @param failureMessage
	 * @param screenshotfilename
	 * @throws JSONException
	 */
	public void formJson(String failedMethodName, String failureMessage, String screenshotfilename)
			throws JSONException {

		JSONObject objFields = new JSONObject();

		JSONObject objProjID = new JSONObject();
		objProjID.put("id", jsonParams.getProjectID());

		objFields.put("project", objProjID);

		objFields.put("summary", "#Automated " + failedMethodName + " Milli secs Time: " + System.currentTimeMillis());

		JSONObject objAssigneName = new JSONObject();
		objAssigneName.put("name", jsonParams.getAssignee());

		objFields.put("assignee", objAssigneName);

		JSONObject objReporterName = new JSONObject();
		objReporterName.put("name", jsonParams.getReporter());

		/*
		 * objFields.put("reporter", objReporterName);
		 */
		if ((failureMessage == null) || (failureMessage.equals(""))) {
			failureMessage = "#Automated Jira with no error Milli secs time: " + System.currentTimeMillis();
		} else
			failureMessage = "#Automated " + failureMessage + " Milli secs time: " + System.currentTimeMillis();
		objFields.put("description", failureMessage);

		JSONObject objIssuType = new JSONObject();
		objIssuType.put("id", jsonParams.getIssueType());

		objFields.put("issuetype", objIssuType);

		JSONObject obj = new JSONObject();
		obj.put("fields", objFields);

		//System.out.println(obj);

		createIssueInJira(failedMethodName, obj.toString(), screenshotfilename);

	}

	/**
	 * Creates Issue in JIRA through Restful API
	 * 
	 * @param string
	 *            - json object
	 * @param screenshotfilename
	 */
	private void createIssueInJira(String methodName, String string, String screenshotfilename) {
		try {
			String name = jsonParams.getUserName();
			String password = AES.decrypt(jsonParams.getPassWord(), "Innominds123$");
			// String authString = name + ":" + password;
			// byte[] authEncBytes = Base64.encode(authString.getBytes());
			String auth = new String(Base64.encode(name + ":" + password));
			String data = string;
			Client client = Client.create();
			String url = jsonParams.getURL();
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.header("Authorization", "Basic " + auth).type("application/json")
					.accept("application/json").post(ClientResponse.class, data);

			int statusCode = response.getStatus();
			if (statusCode == 401) {
				throw new AuthenticationException("Invalid Username or Password");
			}
			String responseChk = response.getEntity(String.class);
			//System.out.println(responseChk);

			org.json.simple.JSONObject jsonObject = null;
			JSONParser parser = new JSONParser(); // this needs the
													// "json-simple" library
			Object obj = parser.parse(responseChk);
			jsonObject = (org.json.simple.JSONObject) obj;
			String attachUrl = (String) jsonObject.get("self");
			// String pathname = Constants.SCREENSHOT_FOLDER_PATH +
			// File.separator + methodName + File.separator
			// + methodName + ".jpg";
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(attachUrl + "/attachments");
			httppost.setHeader("X-Atlassian-Token", "nocheck");
			httppost.setHeader("Authorization", "Basic " + auth);
			MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

			// Attachment
			if (screenshotfilename.length() > 1) {
				File fileToUpload = new File(screenshotfilename);
				if (fileToUpload.exists()) {
					//System.out.println("Screenshot file name is: " + screenshotfilename);
					FileBody fileBody = new FileBody(fileToUpload, "application/octet-stream");
					entity.addPart("file", fileBody);
					// fileToUpload.
				}

			}

			httppost.setEntity(entity);
			HttpResponse httpResponse = null;
			try {
				httpResponse = httpclient.execute(httppost);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			HttpEntity result = httpResponse.getEntity();
			//System.out.println(result.getContent().toString());
			//System.out.println("HTTP Resonse Status Code is  = " + httpResponse.getStatusLine().getStatusCode());
//			if (httpResponse.getStatusLine().getStatusCode() == 200)
//				System.out.println("Screen shot attached successfully to JIRA.");
//			else
//				System.out.println("Screen shot Attachment Failed.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}