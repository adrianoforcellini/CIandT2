//package com.challenge.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
//    }
//
////    Por padrão, o Spring Security provem dois endpoints relacionados à tokens existentes,
////    que são /oauth/check_token e /oauth/token_key. Aqui, estamos liberando o acesso à essas requisições.
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        int ACCESS_TOKEN_VALIDITY_IN_SECONDS = 300000;
//        int REFRESH_TOKEN_VALIDITY_IN_SECONDS = 300000;
//        clients.inMemory()
//                .withClient("client-id")
//                .secret("secret-id")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .scopes("read", "write", "trust")
//                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_IN_SECONDS)
//                .refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_IN_SECONDS);
//    }
////    Com isso estamos dizendo que os tokens ficarão armazenados na memória e estarão disponíveis através
////    do client client-id e do secret secret-id. Esses dois dados serão importantes na hora de gerarmos os
////    tokens. Além disso, estamos dando acesso aos usuários através de password, authorization_code,
////    refresh_token e implicit, com os escopos de leitura e/ou escrita. Também foram definidos os tempos que o
////    token de acesso e o refresh token levarão para expirar, em segundos. O refresh token é utilizado
////    para atualizar o token de segurança de um usuário, gerando um novo token e um novo tempo de expiração.
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
//    }
//
////    Estamos utilizando a anotação @Autowired em um Bean que não está definido. Portanto, iremos criá-lo
////    agora. Para isso, criaremos no mesmo pacote uma classe chamada WebSecurityConfigAdapter.java
////    e colocaremos nela a definição do Bean do gerenciador de autenticação.
//}