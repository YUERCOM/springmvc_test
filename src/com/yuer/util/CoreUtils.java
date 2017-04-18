package com.yuer.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class CoreUtils extends PropertyPlaceholderConfigurer{
	
	private static Map<String, String> propertyMap;
	
	@Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        propertyMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertyMap.put(keyStr, value);
        }
    }
	
	/**
	 * 根据  key 获取配置文件中的value值
	 * @param name
	 * @return
	 */
	public static String getProperty(String key) {
        return propertyMap.get(key);
    }
	
}
