
package org.jasig.portlet.survey.service.jpa;

import java.lang.reflect.Constructor;
import org.dozer.BeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JpaEntityFactory implements BeanFactory {
    private Logger log = LoggerFactory.getLogger(JpaEntityFactory.class);


    @Override
    public Object createBean(Object sourceObject, Class<?> sourceClass, String beanId) {
        Object instance = null;
        try {
            Class cls = Thread.currentThread().getContextClassLoader().loadClass(beanId);
            Constructor constructor = cls.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance = constructor.newInstance();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return instance;
    }
}
