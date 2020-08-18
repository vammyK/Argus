package com.healthcheck.argus.service.executions;

import com.healthcheck.argus.model.General;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HTTPService implements ExecutionService {
    @Override
    public Boolean executeRequest(String endpoint, General general) throws HealthException {
        OkHttpClient client = new OkHttpClient.Builder().callTimeout(general.getHttpClientTimeout(), TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url(endpoint).build();

        try (Response rs = client.newCall(request).execute()) {
            if (rs.code() != 200) {
                throw new HealthException(rs.message());
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            throw new HealthException(e);
        }
    }
}
