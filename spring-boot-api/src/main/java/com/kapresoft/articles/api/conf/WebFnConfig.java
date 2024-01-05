package com.kapresoft.articles.api.conf;

import com.kapresoft.articles.api.webfn.UserHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class WebFnConfig {

    /**
     * /fn/* routing
     * @return RouterFunction
     */
    @Bean
    RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return RouterFunctions.route()
                .path("/fn", userHandler::routerFn)
                .build();
    }

}
