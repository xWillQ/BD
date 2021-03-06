package com.kafedra.aaapp.filter

import com.google.inject.Singleton
import com.kafedra.aaapp.di.injector.InjectLogger
import javax.servlet.*
import org.apache.logging.log4j.Logger

@Singleton
class CharsetFilter : Filter {
    @InjectLogger
    lateinit var logger: Logger

    @Suppress("EmptyFunctionBlock")
    override fun init(config: FilterConfig) {}

    override fun doFilter(request: ServletRequest, response: ServletResponse, next: FilterChain) {
        logger.info("Filtering incoming request")
        request.characterEncoding = "UTF-8"
        response.contentType = "text/html; charset=UTF-8"
        response.characterEncoding = "UTF-8"
        next.doFilter(request, response)
    }

    @Suppress("EmptyFunctionBlock")
    override fun destroy() {}
}
