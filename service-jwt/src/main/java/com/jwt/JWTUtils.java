package com.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.Console;
import java.util.*;

//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//
//import java.security.SignatureException;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.util.Date;
//import com.fangjia.common.base.ResponseCode;
//import io.jsonwebtoken.SignatureAlgorithm;
//
///**
// * class name
// * <p>
// * Created  by  renxingWei  on  2019/3/12
// **/
public class JWTUtils {
//    private static RSAPrivateKey priKey;
//    private static RSAPublicKey pubKey;
//
//    private static class SingletonHolder {
//        private static final JWTUtils INSTANCE = new JWTUtils();
//    }
//
//    public synchronized static JWTUtils getInstance(String modulus, String privateExponent, String publicExponent) {
//        if (priKey == null && pubKey == null) {
//            priKey = RSAUtils.getPrivateKey(modulus, privateExponent);
//            pubKey = RSAUtils.getPublicKey(modulus, publicExponent);
//        }
//        return SingletonHolder.INSTANCE;
//    }
//
//    public synchronized static void reload(String modulus, String privateExponent, String publicExponent) {
//        priKey = RSAUtils.getPrivateKey(modulus, privateExponent);
//        pubKey = RSAUtils.getPublicKey(modulus, publicExponent);
//    }
//
//    public synchronized static JWTUtils getInstance() {
//        if (priKey == null && pubKey == null) {
//            priKey = RSAUtils.getPrivateKey(RSAUtils.modulus, RSAUtils.private_exponent);
//            pubKey = RSAUtils.getPublicKey(RSAUtils.modulus, RSAUtils.public_exponent);
//        }
//        return SingletonHolder.INSTANCE;
//    }
//
//    /**
//     * 获取Token
//     * @param uid 用户ID
//     * @param exp 失效时间，单位分钟
//     * @return
//     */
//    public static String getToken(String uid, int exp) {
//        long endTime = System.currentTimeMillis() + 1000 * 60 * exp;
//        return Jwts.builder().setSubject(uid).setExpiration(new Date(endTime))
//                .signWith(SignatureAlgorithm.RS512, priKey).compact();
//    }
//
//    /**
//     * 获取Token
//     * @param uid 用户ID
//     * @return
//     */
//    public String getToken(String uid) {
//        long endTime = System.currentTimeMillis() + 1000 * 60 * 1440;
//        return Jwts.builder().setSubject(uid).setExpiration(new Date(endTime))
//                .signWith(SignatureAlgorithm.RS512, priKey).compact();
//    }
//
//    /**
//     * 检查Token是否合法
//     * @param token
//     * @return JWTResult
//     */
//    public JWTResult checkToken(String token) {
//        try {
//            Claims claims = Jwts.parser().setSigningKey(pubKey).parseClaimsJws(token).getBody();
//            String sub = claims.get("sub", String.class);
//            return new JWTResult(true, sub, "合法请求", ResponseCode.SUCCESS_CODE.getCode());
//        } catch (ExpiredJwtException e) {
//            // 在解析JWT字符串时，如果‘过期时间字段’已经早于当前时间，将会抛出ExpiredJwtException异常，说明本次请求已经失效
//            return new JWTResult(false, null, "token已过期", ResponseCode.TOKEN_TIMEOUT_CODE.getCode());
//        } catch (SignatureException e) {
//            // 在解析JWT字符串时，如果密钥不正确，将会解析失败，抛出SignatureException异常，说明该JWT字符串是伪造的
//            return new JWTResult(false, null, "非法请求", ResponseCode.NO_AUTH_CODE.getCode());
//        } catch (Exception e) {
//            return new JWTResult(false, null, "非法请求", ResponseCode.NO_AUTH_CODE.getCode());
//        }
//    }
//
//    public static class JWTResult {
//        private boolean status;
//        private String uid;
//        private String msg;
//        private int code;
//
//        public JWTResult() {
//            super();
//        }
//
//        public JWTResult(boolean status, String uid, String msg, int code) {
//            super();
//            this.status = status;
//            this.uid = uid;
//            this.msg = msg;
//            this.code = code;
//        }
//
//        public int getCode() {
//            return code;
//        }
//
//        public void setCode(int code) {
//            this.code = code;
//        }
//
//        public String getMsg() {
//            return msg;
//        }
//
//        public void setMsg(String msg) {
//            this.msg = msg;
//        }
//
//        public boolean isStatus() {
//            return status;
//        }
//
//        public void setStatus(boolean status) {
//            this.status = status;
//        }
//
//        public String getUid() {
//            return uid;
//        }
//
//        public void setUid(String uid) {
//            this.uid = uid;
//        }
//    }
//}

    //token 密钥
    private static String secret = "secret";//(这个密钥不能泄露，以后可以配置到配置中心动态管理)

    private static Algorithm algorithm = Algorithm.HMAC256(secret);

    public static void main(String[] args) {
        JWTUtils demo = new JWTUtils();
        //String createToken = demo.createToken();
        //System.out.println(createToken);
        String createTokenWithClaim = demo.createTokenWithClaim();
        demo.verifyToken(createTokenWithClaim);

    }

    public String createToken() {
        try {
            //头部信息
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("alg", "HS256");
            map.put("typ", "JWT");

            Date nowDate = new Date();
            Date expireDate = getAfterDate(nowDate, 0, 0, 0, 2, 0, 0);//2小过期

            String token = JWT.create()
                    /*设置头部信息 Header*/
                    .withHeader(map)
                    /*设置 载荷 Payload*/
                    .withIssuer("SERVICE")//签名是有谁生成 例如 服务器
                    .withSubject("this is test token")//签名的主题
                    //.withNotBefore(new Date())//定义在什么时间之前，该jwt都是不可用的.
                    .withAudience("APP")//签名的观众 也可以理解谁接受签名的
                    .withIssuedAt(nowDate) //生成签名的时间
                    .withExpiresAt(expireDate)//签名过期的时间
                    /*签名 Signature */
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public String createTokenWithClaim() {

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            Date nowDate = new Date();
            Date expireDate = getAfterDate(nowDate, 0, 0, 0, 2, 0, 0);//2小过期
            map.put("alg", "HS256");
            map.put("typ", "JWT");
            String token = JWT.create()
                    /*设置头部信息 Header*/
                    .withHeader(map)
                    /*设置 载荷 Payload*/
                    .withClaim("loginName", "userName")
                    .withIssuer("SERVICE")//签名是有谁生成 例如 服务器
                    .withSubject("this is test token")//签名的主题
                    //.withNotBefore(new Date())//定义在什么时间之前，该jwt都是不可用的.
                    .withAudience("APP")//签名的观众 也可以理解谁接受签名的
                    .withIssuedAt(nowDate) //生成签名的时间
                    .withExpiresAt(expireDate)//签名过期的时间
                    /*签名 Signature */
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * 返回一定时间后的日期
     *
     * @param date   开始计时的时间
     * @param year   增加的年
     * @param month  增加的月
     * @param day    增加的日
     * @param hour   增加的小时
     * @param minute 增加的分钟
     * @param second 增加的秒
     * @return
     */
    public Date getAfterDate(Date date, int year, int month, int day, int hour, int minute, int second) {
        if (date == null) {
            date = new Date();
        }

        Calendar cal = new GregorianCalendar();

        cal.setTime(date);
        if (year != 0) {
            cal.add(Calendar.YEAR, year);
        }
        if (month != 0) {
            cal.add(Calendar.MONTH, month);
        }
        if (day != 0) {
            cal.add(Calendar.DATE, day);
        }
        if (hour != 0) {
            cal.add(Calendar.HOUR_OF_DAY, hour);
        }
        if (minute != 0) {
            cal.add(Calendar.MINUTE, minute);
        }
        if (second != 0) {
            cal.add(Calendar.SECOND, second);
        }
        return cal.getTime();
    }

    public void verifyToken(String token) {


        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("SERVICE")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);// 错误则抛异常，不是有效的token
            String subject = jwt.getSubject();
            Map<String, Claim> claims = jwt.getClaims();
            Claim claim = claims.get("loginName");
            System.out.println(claim.asString());
            List<String> audience = jwt.getAudience();
            System.out.println(subject);
            System.out.println(audience.get(0));
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
        }
    }
}
