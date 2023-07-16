/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusinho.mstdnrssbot.utils.mastodon.impl;

import com.edusinho.mstdnrssbot.utils.mastodon.MastodonUtil;
import mastodon4j.Mastodon;
import mastodon4j.MastodonFactory;
import mastodon4j.domain.Service;
import mastodon4j.entity.Account;
import mastodon4j.entity.Field;
import mastodon4j.entity.Status;
import mastodon4j.entity.request.StatusUpdate;
import mastodon4j.entity.share.Response;

/**
 *
 * @author user
 */
public class MastodonUtilImpl implements MastodonUtil{
    private Mastodon mastodon;

    @Override
    public void login(Service service, String uri, String accessToken) {
        mastodon = MastodonFactory.getInstance(service,uri, accessToken);
    }

    
    

    @Override
    public void publish(String content, String visibility) {
        StatusUpdate su = new StatusUpdate();
        su.setContent(content);
        su.setVisibility(visibility);
        Response<Status> st= mastodon.postStatus(su);
        System.out.println("Post Status result: "+su.getContent()+" - "+st.get().getId());
    }

    @Override
    public String isOnline() {
        Response<Account> me = mastodon.verifyCredentials();
        return me.get().getDisplayName();
    }

    @Override
    public boolean isPublishedYet(String title) {
        return false;
    }
    
    
}
