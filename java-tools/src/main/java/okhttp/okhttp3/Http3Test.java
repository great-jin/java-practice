package okhttp.okhttp3;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

public class Http3Test {

    @Test
    public void Demo1() {
        System.out.println(post("http://127.0.0.1:8080", "hello"));
    }

    public String post(String url, String params) {
        OkHttpClient client = new OkHttpClient();
        String answer = "";
        // 组装键值，name 为属性名，params 为键值
        RequestBody formBody = new FormBody.Builder()
                .add("name", params)
                .build();
        // 组装请求头
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        // 该方法容易触发 IOException 异常
        try {
            // 获取返回值
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                answer += response.body().string();
            } else {
                answer += "error!";
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return answer;
    }
}
