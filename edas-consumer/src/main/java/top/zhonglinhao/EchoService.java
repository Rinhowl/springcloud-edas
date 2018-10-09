package top.zhonglinhao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <BR>
 * 
 * @author Rinhowl
 * @since zhong.linhao@2018年10月9日  
 *
 */
@FeignClient(name = "service-provider")
public interface EchoService{
   @GetMapping("/echo/{str}")
   String echo(@PathVariable("str") String str);
}
