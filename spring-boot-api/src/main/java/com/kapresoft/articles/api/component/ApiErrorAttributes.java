package com.kapresoft.articles.api.component;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.*;

//@Component
@SuppressWarnings("unused")
public class ApiErrorAttributes extends DefaultErrorAttributes {

    private final CustomBooleanEditor booleanEditor;

    public ApiErrorAttributes() {
        this.booleanEditor = new CustomBooleanEditor(true);
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        ErrorAttributeOptions.Include[] includes = options.getIncludes().toArray(new ErrorAttributeOptions.Include[0]);
        ErrorAttributeOptions customOptions = getDetailsOptions(webRequest, options);
        final Map<String, Object> attr = super.getErrorAttributes(webRequest, customOptions);

//        HttpStatus status = HttpStatus.valueOf((Integer) attr.getOrDefault("status", ""));
//        String detail = attr.getOrDefault("message", "Unknown").toString();
//        ProblemDetail p = ProblemDetail.forStatus(status);
//        URI type = new DefaultUriBuilderFactory()
//                .uriString("https://yoursite.acme.com/bad-request/{error-code}")
//                .build(Map.of("error-code", "error-code-value"));
//        p.setDetail(detail);
//        p.setTitle(detail);
//        p.setType(type);
//        p.setProperty("hint", "hint-value");
//        attr.put("detail", p);
//
//        attr.remove("message");
//        attr.remove("status");
//        attr.remove("error");
        return attr;
    }

    /**
     * ?details=1|0|yes|no|true|false
     * @param webRequest Web Request
     * @return Boolean The boolean
     */
    private Boolean isShowDetails(WebRequest webRequest) {
        booleanEditor.setAsText(webRequest.getParameter("details"));
        return (Boolean) booleanEditor.getValue();
    }

    /**
     * <b>With ?details=0</b>
     * <pre>
     * {
     *   "timestamp": "2023-05-15T17:37:56.618+00:00",
     *   "status": 400,
     *   "error": "Bad Request",
     *   "path": "/api/users/a"
     * }
     * </pre>
     * <b>With ?details=1</b>
     * <pre>
     * {
     *   "timestamp": "2023-05-15T17:33:52.709+00:00",
     *   "status": 400,
     *   "error": "Bad Request",
     *   "exception": "org.springframework.web.method.annotation.MethodArgumentTypeMismatchException",
     *   "trace": "(stack-trace)",
     *   "message": "Failed to convert value of type 'java.lang.String' to required type 'long'; For input string: \"a\"",
     *   "path": "/api/users/a"
     * }
     * </pre>
     *
     * @param webRequest The web request
     * @param existingOptions {@link ErrorAttributeOptions} options
     */
    private ErrorAttributeOptions getDetailsOptions(WebRequest webRequest, ErrorAttributeOptions existingOptions) {
        Boolean showDetails = isShowDetails(webRequest);
        ErrorAttributeOptions detailsOptions = ErrorAttributeOptions.of(MESSAGE);
        if (Boolean.TRUE == showDetails) {
            detailsOptions = ErrorAttributeOptions.of(STACK_TRACE, EXCEPTION, BINDING_ERRORS);
        }
        ErrorAttributeOptions.Include[] existing = existingOptions.getIncludes()
                .toArray(new ErrorAttributeOptions.Include[0]);
        detailsOptions.including(existing);
        return detailsOptions;
    }
}
