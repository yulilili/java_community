package life.majiang.community.Controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${server.client.id}")
    private String Client_id;

    @Value("${server.client.secret}")
    private String Client_secret;

    @Value("${server.redirect.uri}")
    private String Redirect_uri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(Client_id);
        accessTokenDTO.setClient_secret(Client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(Redirect_uri);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.gitUser(accessToken);

        if(githubUser!=null){
            //登录成功 写cookie和session
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";

        }
        else {
            //登录失败 重新登录
            return "redirect:/";

        }
    }

}
