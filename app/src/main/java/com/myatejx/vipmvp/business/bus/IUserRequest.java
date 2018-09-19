package com.myatejx.vipmvp.business.bus;

import com.myatejx.architecture.business.bus.IRequest;

/**
 * @author xmj
 * @date 2018/9/19
 */
public interface IUserRequest extends IRequest {

    void signIn(String phonenumber, String password);

    void signUp(String phonenumber, String password);

    void signOut();

    void forgetPassword(String phonenumber);
}
