package com.example.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("testClientId")
                .secret("testSecret")
                .redirectUris("http://localhost:8084/oauth2/callback")  // 인증 완료 후 이동할 클라이언트 웹페이지 주소로 code값 실어서 보낸다.
                .authorizedGrantTypes("authorization_code")             // 인증 방식
                .scopes("read", "write")                                // 인증 후 얻은 accessToken으로 접근할 수 있는 리소스의 범위
                .accessTokenValiditySeconds(30000);                     // 발급된 accessToken으로 유효시간(초)

    }

}
