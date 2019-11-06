
# SSO 인증 처리 샘플 

## Summary

동일 도메인내에서 쿠키 기반의 SSO를 사용하기 위한 인증 서비스

## Login 컨트롤러

로그인과 관련된 컨트롤러로, login 시 아래 로직을 통해, 쿠키에 jwt 토큰을 생성하여 저장 한다.

```java

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model){
        if (username == null || !credentials.containsKey(username) || !credentials.get(username).equals(password)){
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }

        String token = jwtUtil.generateToken(signingKey, username);
        jwtUtil.getCookieUtil().create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

        return "redirect:" + redirect;
    }


```

---

## 참고링크
- https://github.com/hellokoding/hellokoding-courses/tree/master/springboot-examples/springboot-single-sign-on-jwt
