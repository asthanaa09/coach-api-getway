package com.getway.core.model.listeners;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.getway.core.model.BaseEntity;
import com.getway.utils.Utils;

/**
 * Ref:- https://blog.tericcabrel.com/using-mongodb-with-spring-boot-project-part-1/
 * 
 * @author Anurag Asthana
 *
 */
@Component
public class BaseEntityListener extends AbstractMongoEventListener<BaseEntity> {
	
	/**
	 * Set creation time just before converting entity to document
	 */
	@Override
	public void onBeforeConvert(BeforeConvertEvent<BaseEntity> event) {
		super.onBeforeConvert(event);

		if(event.getSource().getCreationTime() == null)
			event.getSource().setCreationTime(Utils.current());
		
		event.getSource().setUpdateTime(Utils.current());
	}
}
