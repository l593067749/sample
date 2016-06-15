#未加密前#
## 
	此时passwordType='PasswordText' 
##
    ----------------------------
    ID: 1
    Address: http://localhost:8080/study-test-web/ws/soap/helloToken
    Encoding: UTF-8
    Http-Method: POST
    Content-Type: text/xml; charset=UTF-8
    Headers: {Accept=[*/*], cache-control=[no-cache], connection=[keep-alive], Content-Length=[854], content-type=[text/xml; charset=UTF-8], host=[localhost:8080], pragma=[no-cache], SOAPAction=[""], user-agent=[Apache CXF 3.1.6]}
    Payload: <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><SOAP-ENV:Header xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"><wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" soap:mustUnderstand="1"><wsse:UsernameToken wsu:Id="UsernameToken-87bf7686-ce9b-424f-af32-03fd78541528"><wsse:Username>client</wsse:Username><wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">clientpass</wsse:Password></wsse:UsernameToken></wsse:Security></SOAP-ENV:Header><soap:Body><ns2:sayHello xmlns:ns2="http://service.server.api.webService.test.module.study.liao.com/"><arg0>world</arg0></ns2:sayHello></soap:Body></soap:Envelope>
    --------------------------------------
    五月 16, 2016 11:37:16 下午 org.apache.cxf.services.HelloServiceTokenImplService.HelloServiceTokenImplPort.HelloServiceToken
    信息: Outbound Message
    ---------------------------
    ID: 1
    Response-Code: 200
    Encoding: UTF-8
    Content-Type: text/xml
    Headers: {}
    Payload: <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><ns2:sayHelloResponse xmlns:ns2="http://service.server.api.webService.test.module.study.liao.com/"><return>helloworld</return></ns2:sayHelloResponse></soap:Body></soap:Envelope>
    --------------------------------------
#加密后#
## 
	如果您将 passwordType 由 PasswordText 改为 PasswordDigest（服务端与客户端都需要做同样的修改），那么就会看到一个加密过的密码 
##
----------------------------
	ID: 1
	Address: http://localhost:8080/study-test-web/ws/soap/helloToken
	Encoding: UTF-8
	Http-Method: POST
	Content-Type: text/xml; charset=UTF-8
	Headers: {Accept=[*/*], cache-control=[no-cache], connection=[keep-alive], Content-Length=[1084], content-type=[text/xml; charset=UTF-8], host=[localhost:8080], pragma=[no-cache], SOAPAction=[""], user-agent=[Apache CXF 3.1.6]}
	Payload: <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><SOAP-ENV:Header xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"><wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" soap:mustUnderstand="1"><wsse:UsernameToken wsu:Id="UsernameToken-e28cde28-03b5-466c-bc79-72cd8933f888"><wsse:Username>client</wsse:Username><wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest">dof0TFnY+ayVVWPXLxRadeTizRk=</wsse:Password><wsse:Nonce EncodingType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary">44CCPe2/IV0S59i+zsQBdQ==</wsse:Nonce><wsu:Created>2016-05-16T15:48:44.720Z</wsu:Created></wsse:UsernameToken></wsse:Security></SOAP-ENV:Header><soap:Body><ns2:sayHello xmlns:ns2="http://service.server.api.webService.test.module.study.liao.com/"><arg0>world</arg0></ns2:sayHello></soap:Body></soap:Envelope>
	--------------------------------------
	五月 16, 2016 11:48:45 下午 org.apache.cxf.services.HelloServiceTokenImplService.HelloServiceTokenImplPort.HelloServiceToken
	信息: Outbound Message
	---------------------------
	ID: 1
	Response-Code: 200
	Encoding: UTF-8
	Content-Type: text/xml
	Headers: {}
	Payload: <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><ns2:sayHelloResponse xmlns:ns2="http://service.server.api.webService.test.module.study.liao.com/"><return>helloworld</return></ns2:sayHelloResponse></soap:Body></soap:Envelope>
	--------------------------------------
5/17/2016 12:11:36 AM 