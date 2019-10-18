**设计模式之适配器模式**

**1、定义：**
指将一个类的接口转换成客户期望的另一个接口，使原本的接口不兼容的类可以一起工作，属于结构型设计模式。

**2、应用场景**

（1）已经存在的类，它的方法和需求不匹配（方法结果相同或相似）的情况。

（2）适配器模式不是软件设计阶段考虑的设计模式，是随着软件维护，由于不同产品、不同厂家造成功能类似而接口不相同情况下的解决方案。恰似亡羊补牢。

生活中也非常的应用场景，例如电源插转换头、手机充电转换头、显示器转接头。

**3、适配器模式在源码中的体现**

Spring中适配器模式也应用得非常广泛，如：SpringAOP中的AdvisorAdapter类，它有三个实现类MethodBeforeAdviceAdapter、AfterReturningAdviceAdapter和ThrowsAdviceAdapter，
先来看顶层接口AdvisorAdapter的源代码：
````
package org.springframework.aop.framework.adapter; 
import org.aopalliance.aop.Advice; 
import org.aopalliance.intercept.MethodInterceptor; 
import org.springframework.aop.Advisor; 
    
public interface AdvisorAdapter { 
    
    boolean supportsAdvice(Advice var1);
     
    MethodInterceptor getInterceptor(Advisor var1); 
}

````
再看 MethodBeforeAdviceAdapter 类：
````
package org.springframework.aop.framework.adapter; 
import java.io.Serializable; 
import org.aopalliance.aop.Advice; 
import org.aopalliance.intercept.MethodInterceptor; 
import org.springframework.aop.Advisor; 
import org.springframework.aop.MethodBeforeAdvice;
 
class MethodBeforeAdviceAdapter implements AdvisorAdapter, Serializable { 
    
    MethodBeforeAdviceAdapter() {
    }
    
    public boolean supportsAdvice(Advice advice) { 
        return advice instanceof MethodBeforeAdvice; 
    }
    
    public MethodInterceptor getInterceptor(Advisor advisor) { 
        MethodBeforeAdvice advice = (MethodBeforeAdvice)advisor.getAdvice(); 
        return new MethodBeforeAdviceInterceptor(advice); 
    } 
}
````
Spring会根据不同的AOP配置来确定使用对应的Advice，跟策略模式不同的一个方法可以同时拥有多个Advice。

如SpringMVC中的HandlerAdapter 类，它也有多个子类，类图如下：
![Image text](https://github.com/wlc160/img-folder/blob/master/HandlerAdapter.jpg)

其适配调用的关键代码还是在DispatcherServlet的doDispatch()方法中，看源码：

````
protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    HttpServletRequest processedRequest = request; 
    HandlerExecutionChain mappedHandler = null; 
    boolean multipartRequestParsed = false; 
    WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);

    try {
        try {
            ModelAndView mv = null; 
            Object dispatchException = null;
            
            try {            
                processedRequest = this.checkMultipart(request); 
                multipartRequestParsed = processedRequest != request; 
                mappedHandler = this.getHandler(processedRequest); 
                if(mappedHandler == null) { 
                    this.noHandlerFound(processedRequest, response); 
                    return; 
                }
                
                HandlerAdapter ha = this.getHandlerAdapter(mappedHandler.getHandler()); 
                String method = request.getMethod(); 
                boolean isGet = "GET".equals(method);
                 
                if(isGet || "HEAD".equals(method)) { 
                    long lastModified = ha.getLastModified(request, mappedHandler.getHandler()); 
                    if(this.logger.isDebugEnabled()) { 
                        this.logger.debug("Last-Modified value for [" + getRequestUri(request) + "] is: " + lastModified);    
                    }
                    
                    if((new ServletWebRequest(request, response)).checkNotModified(lastModified) && isGet) { 
                        return; 
                    } 
                }
                    
                if(!mappedHandler.applyPreHandle(processedRequest, response)) { 
                    return; 
                }
                    
                mv = ha.handle(processedRequest, response, mappedHandler.getHandler()); 
                if(asyncManager.isConcurrentHandlingStarted()) { 
                    return; 
                }
                    
                this.applyDefaultViewName(processedRequest, mv); 
                mappedHandler.applyPostHandle(processedRequest, response, mv);
            } catch (Exception var20) { 
                dispatchException = var20; 
            } catch (Throwable var21) { 
                dispatchException = new NestedServletException("Handler dispatch failed", var21); 
            }
            
            this.processDispatchResult(processedRequest, response, mappedHandler, mv, (Exception)dispatchException); 
        
        } catch (Exception var22) { 
            this.triggerAfterCompletion(processedRequest, response, mappedHandler, var22); 
        } catch (Throwable var23) { 
            this.triggerAfterCompletion(processedRequest, response, mappedHandler, new NestedServletException("Handler processing failed", var23)); 
        } 
    } finally { 
        if(asyncManager.isConcurrentHandlingStarted()) { 
            if(mappedHandler != null) { 
                mappedHandler.applyAfterConcurrentHandlingStarted(processedRequest, response); 
            } 
        } else if(multipartRequestParsed) { 
            this.cleanupMultipart(processedRequest); 
        } 
    } 
}
````
在doDispatch()方法中调用了getHandlerAdapter()方法，看源码：
````
protected HandlerAdapter getHandlerAdapter(Object handler) throws ServletException { 
    if(this.handlerAdapters != null) { 
        Iterator var2 = this.handlerAdapters.iterator(); 
        while(var2.hasNext()) { 
        
            HandlerAdapter ha = (HandlerAdapter)var2.next(); 
            
            if(this.logger.isTraceEnabled()) { 
                this.logger.trace("Testing handler adapter [" + ha + "]"); 
            }
            
            if(ha.supports(handler)) { 
                return ha; 
            } 
        } 
    }
    throw new ServletException("No adapter for handler [" + handler + "]: The 
DispatcherServlet configuration needs to include a HandlerAdapter that supports this 
handler"); 
}
````
在 getHandlerAdapter()方法中循环调用了supports()方法判断是否兼容，循环迭代集合中的Adapter又是在初始化时早已赋值

**4、优点：**

（1）能提高类的透明性和复用，现有的类复用但不需要改变。

（2）目标类和适配器类解耦，提高程序的扩展性。

（3）在很多业务场景中符合开闭原则。

**5、缺点：**

（1）适配器编写过程需要全面考虑，可能会增加系统的复杂性。

（2）增加代码阅读难度，降低代码可读性，过多使用适配器会使系统代码变得凌乱。


























