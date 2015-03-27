/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
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
            Class<?> cls = Thread.currentThread().getContextClassLoader().loadClass(beanId);
            Constructor<?> constructor = cls.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance = constructor.newInstance();
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return instance;
    }
}
