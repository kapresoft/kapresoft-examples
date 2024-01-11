package com.kapresoft.articles.api.webfn;

import com.kapresoft.articles.api.service.UserService;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.servlet.function.RequestPredicates.accept;

@Component
public class UserHandler {

    record CollectionResponseObject(String link, Object results) { }

    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public RouterFunction<ServerResponse> routerFn() {
        return RouterFunctions.route()
                .GET("/user/{id}", accept(APPLICATION_JSON), this::specificUser)
                .GET("/user/", accept(APPLICATION_JSON), this::allUsers)
                .build();
    }

    public ServerResponse specificUser(ServerRequest request) {
        Long userId = Long.parseLong(request.pathVariable("id"));
        String selfLink = UriComponentsBuilder.fromPath(request.path())
                .build().toUriString();
        UserRepresentation user = UserRepresentation.builder().link(selfLink).user(userService.getUserById(userId)).build();
        return ServerResponse.ok()
                .header("Link", selfLink)
                .body(user);

    }

    public ServerResponse allUsers(ServerRequest request) {
        String selfLink = UriComponentsBuilder.fromPath(request.path())
                .build().toUriString();
        return ServerResponse.ok()
                .header("Link", selfLink)
                .body(new CollectionResponseObject(selfLink, userService.allUsers()));
    }


}
