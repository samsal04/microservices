package com.webfluxdemo.webfluxdemo.router;

import com.webfluxdemo.webfluxdemo.handler.CustomerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler customerHandler;

    public RouterFunction<ServerResponse> routerFunction(){

        return RouterFunctions.route()
                .GET("/router/customers",customerHandler::customerListNoDelay)
                .build();
    }
}
