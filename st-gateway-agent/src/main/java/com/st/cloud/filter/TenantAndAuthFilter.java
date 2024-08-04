package com.st.cloud.filter;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.st.cloud.api.SystemApi;
import com.st.cloud.common.constants.SecurityConstant;
import com.st.cloud.common.pojo.R;
import com.st.cloud.framework.security.core.util.AuthUtil;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class TenantAndAuthFilter extends AbstractGatewayFilterFactory<TenantAndAuthFilter.Config> {

    private final WebClient webClient;
    private final AuthUtil authUtil;

    public TenantAndAuthFilter(ReactorLoadBalancerExchangeFilterFunction lbFunction, AuthUtil  authUtil) {
        super(Config.class);
        this.webClient = WebClient.builder().filter(lbFunction).build();
        this.authUtil = authUtil;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            // 获取请求的域名
            String host = request.getURI().getHost();

            R result = checkTenantId(host).block();
            // 设置下游请求头
            if(Objects.nonNull(result) && StringUtil.equals(result.getCode(), "0000")) {
                String tenantId = String.valueOf(result.getData());
                ServerHttpRequest modifiedRequest = request.mutate()
                        .header(SecurityConstant.HEADER_TENANT_ID, tenantId)
                        .build();

                // 检查token 是否有效
                if (!checkToken(request, tenantId)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

                return chain.filter(exchange.mutate().request(modifiedRequest).build());
            }

            return chain.filter(exchange);
        };
    }

    private boolean checkToken(ServerHttpRequest request, String tenantId) {
        // 获取请求头的token
        String path = request.getURI().getPath();
        if (!StringUtil.equals("/agent/user/login", path)) {// TODO 再加一个IP验证
            String token = request.getHeaders().getFirst(SecurityConstant.HEADER_TOKEN);
            if(StringUtil.isBlank(token)) {
                return false;
            }
            if(!authUtil.checkToken(token, tenantId)) {
                return false;
            }
            // 把token传给下游，以便他们通过token获取用户信息，进行权限校验
            request.mutate().header(SecurityConstant.HEADER_TOKEN, token);
            return true;
        }
        return true;
    }

    public static class Config {
        // 配置类，如果需要可以添加配置属性
    }

    private Mono<R> checkTenantId(String domain) {
        return webClient.get()
                .uri(SystemApi.GET_TENANT_ID, uriBuilder -> uriBuilder.queryParam("domain", domain).build())
                .retrieve().bodyToMono(R.class);
    }

}
