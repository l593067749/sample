package com.liao.sample.webservice.cxf.spring.wss4j;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 廖文强
 * @version V1.0
 * @Title: ServerPasswordCallback
 * @Package com.liao.sample.webservice.cxf.spring.wss4j
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/5/19 14:29
 */
@Component
public class ServerPasswordCallback implements CallbackHandler {

    private static Map<String,String> userMap=new HashMap<String,String>();
    static{
        userMap.put("client","clientpass");
        userMap.put("server","serverpass");
    }
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
      WSPasswordCallback callback= (WSPasswordCallback)callbacks[0];
        String clientUser=callback.getIdentifier();
        String password=userMap.get(clientUser);
        if(password!=null){
            callback.setPassword(password);
        }
    }
}
