/*
 * Copyright 2015 nqcx.org All right reserved. This software is the confidential and proprietary information
 * of nqcx.org ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with nqcx.org.
 */

package org.nqcx.commons.mq;

import javax.jms.Destination;

/**
 * @author naqichuan 15/1/3 12:41
 */
public interface MqDestination {

    Destination getDestination();
}
