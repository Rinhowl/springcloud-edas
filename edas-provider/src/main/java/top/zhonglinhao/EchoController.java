package top.zhonglinhao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <BR>
 * 
 * @author Rinhowl
 * @since zhong.linhao@2018年10月9日  
 *
 */
@RestController
public class EchoController {
    @GetMapping("/echo/{string}")
   public String echo(@PathVariable String string) {
       return string;
   }
}
