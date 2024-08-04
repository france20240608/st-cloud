package com.st.cloud.filter;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.st.cloud.api.SystemApi;
import com.st.cloud.common.pojo.R;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static com.st.cloud.common.base.Constant.HEADER_TENANT_ID;

@Component
public class TenantFilter extends AbstractGatewayFilterFactory<TenantFilter.Config> {

    private final WebClient webClient;

    public TenantFilter(ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        super(Config.class);
        this.webClient = WebClient.builder().filter(lbFunction).build();
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
                ServerHttpRequest modifiedRequest = request.mutate()
                        .header(HEADER_TENANT_ID, String.valueOf(result.getData()))
                        .build();
                return chain.filter(exchange.mutate().request(modifiedRequest).build());
            }

            return chain.filter(exchange);
        };
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
