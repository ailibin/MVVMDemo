package me.goldze.mvvmhabit.http.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by goldze on 2017/5/10.
 */
public class BaseInterceptor implements Interceptor {
    private Map<String, String> headers;

    public BaseInterceptor(Map<String, String> headers) {
        this.headers = headers;
    }

    //头部数据
    public Map<String, String> getCommonHeader() {
        Map<String, String> headers = new HashMap<>();
        headers.put("hs-token", "");
        headers.put("hs-device-type", "'andapp'");
        headers.put("hs-lang", "'zh'");
        headers.put("hs-lang", "'zh'");
        return headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request()
                .newBuilder();
        if (headers == null) {
            //取默认的配置
            this.headers = getCommonHeader();
        }
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String headerKey : keys) {
                builder.addHeader(headerKey, headers.get(headerKey)).build();
            }
        }
        //请求信息
        return chain.proceed(builder.build());
    }
}