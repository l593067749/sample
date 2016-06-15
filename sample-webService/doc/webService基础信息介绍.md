
# webService #

## 1、webService到底是什么？##

> 一言以蔽之：WebService是一种跨编程语言和跨操作系统平台的远程调用技术。
从深层次看，WebService是建立可互操作 的分布式应用程序的新平台，是一个平台，是一套标准。它定义了应用程序如何在Web上实现互操作性，你可以用任何你喜欢的语言，在任何你喜欢的平台上写 Web service ，只要我们可以通过Web service标准对这些服务进行查询和访问。 最后，我们还必须有一种方法来对这个Web service进行远程调用,这种方法实际是一种远程过程调用协议(RPC)。为了达到互操作性，这种RPC协议还必须与平台和编程语言无关。

## 2、webService的作用？ ##

> 1、跨防火墙交互
 
> 2、企业应用程序集合

> 3、B2B集成(跨公司的商务交易集成)

> 4、软件和数据重用

## 3、webService平台技术 ##

### XML+XSD,SOAP和WSDL就是构成WebService平台的三大技术。

 >   1、	XML是WebService平台中表示数据的格式。XML Schema(XSD)它定义了一套标准的数据类型，WebService平台就是用XSD来作为其数据类型系统的。当你用某种语言(如VB.NET或C#)来构造一个Web service时，为了符合WebService标准，所有你使用的数据类型都必须被转换为XSD类型。
    
 >   2、	SOAP协议 = HTTP协议 + XML数据格式，SOAP协议定义了SOAP消息的格式，SOAP协议是基于HTTP协议的，SOAP也是基于XML和XSD的，XML是SOAP的数据编码方式。打个比 喻：HTTP就是普通公路，XML就是中间的绿色隔离带和两边的防护栏，SOAP就是普通公路经过加隔离带和防护栏改造过的高速公路。
 
 >	3、	WSDL： WebService也一样，WebService客户端要调用一个WebService服务，首先要有知道这个服务的地址在哪，以及这个服务里有什么方 法可以调用，所以，WebService务器端首先要通过一个WSDL文件来说明自己家里有啥服务可以对外调用，服务是什么（服务中有哪些方法，方法接受 的参数是什么，返回值是什么），服务的网络地址用哪个url地址表示，服务通过什么方式来调用。WSDL(Web Services Description Language)就是这样一个基于XML的语言，用于描述Web Service及其函数、参数和返回值。它是WebService客户端和服务器端都 能理解的标准格式。因为是基于XML的，所以WSDL既是机器可阅读的，又是人可阅读的，这将是一个很大的好处。一些最新的开发工具既能根据你的 Web service生成WSDL文档，又能导入WSDL文档，生成调用相应WebService的代理类代码。WSDL 文件保存在Web服务器上，通过一个url地址就可以访问到它。客户端要调用一个WebService服务之前，要知道该服务的WSDL文件的地址。 WebService服务提供商可以通过两种方式来暴露它的WSDL文件地址：1.注册到UDDI服务器，以便被人查找；2.直接告诉给客户端调用者。
 

##4、 Web Service的开源实现

> Web Service更多是一种标准，而不是一种具体的技术。不同的平台，不同的语言大都提供Web Service的开发实现，在JAVA领域，Web Service的框架很多，例如：Axis1&2，Xfire，CXF，java6自带Web Service引擎。 

>
 1）从JavaSE6.0开始，Java引入了对Web Service的原生支持。我们只需要简单的使用Java的Annotation标签即可将标准的Java方法发布成Web Service。但不是所有的Java类都可以发布成Web Service。Java类若要成为一个实现了Web Service的bean，它需要遵循下边这些原则：   这个类必须是public类  这些类不能是final的或者abstract  这个类必须有一个公共的默认构造函数 这个类绝对不能有finalize()方法.简单的说下注意事项：当你使用的是JDK1.5的时候，就必须要有jaxws-api-2.0.jar这个包的支持，如果使用的是JDK1.6就不用使用这个包了。因为1.6里已经有相关实现。
 
> 
 2）Axis2（Apache eXtensible Interaction System）是Apache下的一个重量级WebService框架，准确说它是一个Web Services / SOAP / WSDL 的引擎，是WebService框架的集大成者，它能不但能制作和发布WebService，而且可以生成Java和其他语言版WebService客户 端和服务端代码。这是它的优势所在。但是，这也不可避免的导致了Axis2的复杂性，使用过的开发者都知道，它所依赖的包数量和大小都是很惊人的，打包部 署发布都比较麻烦，不能很好的与现有应用整合为一体。但是如果你要开发Java之外别的语言客户端，Axis2提供的丰富工具将是你不二的选择。

> 
3）XFire是一个高性能的WebService框架，在Java6之前，它的知名度甚至超过了Apache的Axis2，XFire的优点是开发方 便，与现有的Web整合很好，可以融为一体，并且开发也很方便。但是对Java之外的语言，没有提供相关的代码工具。XFire后来被Apache收购 了，原因是它太优秀了，收购后，随着Java6 JWS的兴起，开源的WebService引擎已经不再被看好，渐渐的都败落了。

> 
4）Apache CXF是Apache旗下一个重磅的SOA简易框架，它实现了ESB(企业服务总线)。CXF 继承了 Celtix 和 XFire 两大开源项目的精华，不仅提供了对 JAX-WS 全面的支持，并且提供了多种 Binding 、DataBinding、Transport 以及各种 Format 的支持，并且可以根据实际项目的需要，采用代码优先（Code First）或者 WSDL 优先（WSDL First）来轻松地实现 Web Services 的发布和使用。而且可以天然的和Spring进行无缝集成。Apache CXF已经是一个正式的Apache顶级项目。
 
## 5、既然有了jdk6的JAX-WS为什么还要用其他的开源webService呢？

因为还有好多应用用的是老版本的jdk，而且其他的webService的方案都比较成熟，例如系统整合(spring)以及安全方面，兼容性。下面讲两种开源webService框架：

1、axis2
	
重量级的webService框架，它是一个Web Services / SOAP / WSDL 的引擎，是WebService框架的集大成者，它能不但能制作和发布WebService，而且可以生成Java和其他语言版WebService客户 端和服务端代码。这是它的优势所在。但是，这也不可避免的导致了Axis2的复杂性，使用过的开发者都知道，它所依赖的包数量和大小都是很惊人的，打包部 署发布都比较麻烦，不能很好的与现有应用整合为一体。但是如果你要开发Java之外别的语言客户端，Axis2提供的丰富工具将是你不二的选择。
 
2、Cxf

Apache CXF是Apache旗下一个重磅的SOA简易框架，它实现了ESB(企业服务总线)。CXF 继承了 Celtix 和 XFire 两大开源项目的精华，不仅提供了对 JAX-WS 全面的支持，并且提供了多种 Binding 、DataBinding、Transport 以及各种 Format 的支持，并且可以根据实际项目的需要，采用代码优先（Code First）或者 WSDL 优先（WSDL First）来轻松地实现 Web Services 的发布和使用。而且可以天然的和Spring进行无缝集成。Apache CXF已经是一个正式的Apache顶级项目。



## 6、 webService的例子

### 一、jdk实现（JAX-WS）

1. 服务端
	> 1、 定义一个接口 `IWebService.java`
	   
			package com.liao.webService;
	    	import javax.jws.WebMethod;
	    	import javax.jws.WebService;
	    
	    	@WebService
	    	public interface IWebService {
	    		@WebMethod
	    		public String sayHello(String name); 
	    	}

	> 2、 实现接口 `WebService.java`

			package com.liao.webService;
			import javax.jws.WebMethod;
			import javax.xml.ws.Endpoint;
			
			@javax.jws.WebService
			public class WebService implements IWebService {
			
				
				@WebMethod
				public String sayHello(String name) {
					return "my name is "+name;
				}
			
				
				public static void main(String[] args) {
					
					Endpoint.publish("http://localhost:9001/Service/WebService", new WebService());
					System.out.println("Service success");
					//成功后可访问 地址：http://localhost:9001/Service/WebService 查看
				}
			
			}


2. 客户端
 
    建立客户端测试类 `App.java`

	    import java.net.URL;
	    import javax.xml.namespace.QName;
	    import javax.xml.ws.Service;
	    
	    import com.liao.webService.IWebService;
	    
	    public class App {
	    
		    public static void main(String[] args) throws Exception {
			    URL wsdlUrl = new URL("http://localhost:9001/Service/WebService?wsdl");
			    Service s = Service.create(wsdlUrl, new QName("http://webService.liao.com/","WebServiceService"));
			    IWebService hs = s.getPort(new QName("http://webService.liao.com/","WebServicePort"), IWebService.class);
			    String ret = hs.sayHello("李四");
			    System.out.println(ret);
		    }
	    }

