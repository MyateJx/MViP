package com.myatejx.vipmvp.test;

import com.myatejx.architecture.business.bus.IRequest;

/**
 * @author xmj
 * @date 2018/9/4
 */
public class ViaBus<Q extends IRequest> {

    /*private static List<BaseBus> sBuses = new ArrayList<>();

    public static <Q extends IRequest> BaseBus of(Q iRequest) {
        if (iRequest == null) {
            return null;
        }

        for (BaseBus bus : sBuses) {
            if (bus.request().getClass().getName().equals(iRequest.getClass().getName())) {
                return bus;
            }
        }
        BaseBus baseBus = BaseBus.io();
        baseBus.registerRequestHandler(iRequest);
        sBuses.add(baseBus);
        return baseBus;
    }*/

}
