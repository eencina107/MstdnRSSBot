/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edusinho.mstdnrssbot.utils.mastodon;

import mastodon4j.domain.Service;

/**
 *
 * @author user
 */
public interface MastodonUtil {    
    public void login(Service service, String uri, String accessToken);
    public void publish(String content, String visibility);
    public String isOnline();
    public boolean isPublishedYet(String title);
}
