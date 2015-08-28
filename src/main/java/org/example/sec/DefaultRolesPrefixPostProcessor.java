package org.example.sec;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

/**
 * Disable ROLE_ prefixing. With Spring 4.x, all recognized roles must start with ROLE_.
 * To disable it, this class is necessary as a bean in the Spring security context.
 * @see http://docs.spring.io/spring-security/site/migrate/current/3-to-4/html5/migrate-3-to-4-xml.html#m3to4-role-prefixing
 * @author Lee_Vettleson
 *
 */
public class DefaultRolesPrefixPostProcessor implements BeanPostProcessor, PriorityOrdered {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {

//		// remove this if you are not using JSR-250
//		if(bean instanceof Jsr250MethodSecurityMetadataSource) {
//			((Jsr250MethodSecurityMetadataSource) bean).setDefaultRolePrefix(null);
//		}

		if(bean instanceof DefaultMethodSecurityExpressionHandler) {
			((DefaultMethodSecurityExpressionHandler) bean).setDefaultRolePrefix(null);
		}
		if(bean instanceof DefaultWebSecurityExpressionHandler) {
			((DefaultWebSecurityExpressionHandler) bean).setDefaultRolePrefix(null);
		}
		if(bean instanceof SecurityContextHolderAwareRequestFilter) {
			((SecurityContextHolderAwareRequestFilter)bean).setRolePrefix("");
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public int getOrder() {
		return PriorityOrdered.HIGHEST_PRECEDENCE;
	}
}
