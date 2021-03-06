package com.dragon.springboot.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * @author Mr.Wei
 * @Create: 2022-03-13 13:43
 * @Title：
 */
public class TokenUtils {

    /**
     * 生成token
     * @return
     */
    public static String getToken(String userId,String sign){
        return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2)) // 2小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥
    }
}
