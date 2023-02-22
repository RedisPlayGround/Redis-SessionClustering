package me.saechimdaeki.redissession

import jakarta.servlet.http.HttpServletRequest
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

class SessionLoginArgumentResolver : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        val hasSessionLoginAnnotation = parameter.hasParameterAnnotation(SessionLogin::class.java)

        val hasName: Boolean = String::class.java.isAssignableFrom(parameter.parameterType)

        return hasSessionLoginAnnotation && hasName
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        val request: HttpServletRequest = webRequest.nativeRequest as HttpServletRequest

        val session = request.getSession(false) ?: return null
        return session.getAttribute("name")
    }
}