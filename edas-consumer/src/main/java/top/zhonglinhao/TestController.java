package top.zhonglinhao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * <BR>
 * 
 * @author Rinhowl
 * @since zhong.linhao@2018年10月9日  
 *
 */
@RestController
public class TestController {
     @Autowired
     private RestTemplate restTemplate;
     @Autowired
     private AsyncRestTemplate asyncRestTemplate;
     @Autowired
     private  EchoService echoService;
     
     @GetMapping("/echo-rest/{str}")
     public String rest(@PathVariable String str) {
         return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
     }
     @GetMapping("/echo-async-rest/{str}")
     public String asyncRest(@PathVariable String str) throws Exception{
         ListenableFuture<ResponseEntity<String>> future = asyncRestTemplate.
         getForEntity("http://service-provider/echo/"+str, String.class);
         return future.get().getBody();
     }
     
     @GetMapping("/echo-feign/{str}")
     public String feign(@PathVariable String str) {
         return echoService.echo(str);
     }
}
