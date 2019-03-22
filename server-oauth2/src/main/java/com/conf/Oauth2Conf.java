package com.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

/**
 * class name
 * <p>
 * Created  by  renxingWei  on  2019/3/20
 **/
@Configuration
public class Oauth2Conf extends AuthorizationServerConfigurerAdapter {

    //@Override
    //public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    //    clients.inMemory() // 使用in-memory存储
    //            .withClient("clientID") // client_id
    //            .secret("mySecret") // client_secret
    //            .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
    //            .scopes("app"); // 允许的授权范围
    //}

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("first").secret("passwordforauthserver")
                .redirectUris("http://localhost:8092/").authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("myscope").autoApprove(true).accessTokenValiditySeconds(30).refreshTokenValiditySeconds(1800)
                .and()
                .withClient("second").secret("passwordforauthserver")
                .redirectUris("http://localhost:8091/").authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("myscope").autoApprove(true).accessTokenValiditySeconds(30).refreshTokenValiditySeconds(1800);
    }

}
