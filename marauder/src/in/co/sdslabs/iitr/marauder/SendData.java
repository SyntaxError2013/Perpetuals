package in.co.sdslabs.iitr.marauder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class SendData {

	void sendData(String s) throws ClientProtocolException, IOException {
		String serverUrl = "http://marauder-iitr.appspot.com";
		int TIMEOUT_MILLISEC = 10000; // = 10 seconds
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
		HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
		HttpClient client = new DefaultHttpClient(httpParams);

		HttpPost request = new HttpPost(serverUrl);
		request.setEntity(new ByteArrayEntity(s.getBytes("UTF8")));
		HttpResponse response = client.execute(request);
	}
}
