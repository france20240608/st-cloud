1. Step 1. 构造源串
   源串是由3部分内容用“&”拼接起来的： HTTP请求方式 & urlencode(uri) & urlencode(a=x&b=y&...)

源串构造步骤如下：
第1步：将请求的URI路径进行URL编码（URI不含host，URI示例：/v3/user/get_info）。
请开发者关注：URL编码注意事项，否则容易导致后面签名不能通过验证。

第2步：将除“sig”外的所有参数按key进行字典升序排列。
注：除非OpenAPI文档中特别标注了某参数不参与签名，否则除sig外的所有参数都要参与签名。

第3步：将第2步中排序后的参数(key=value)用&拼接起来，并进行URL编码。
请开发者关注：URL编码注意事项，否则容易导致后面签名不能通过验证。

第4步：将HTTP请求方式（GET或者POST）以及第1步和第3步中的字符串用&拼接起来。
注：Java_SDK_V3.0.6仅支持POST方式，如果用GET可能导致一直计算sig不正确。



源串构造示例如下
（由于是通用说明，这里以/v3/user/get_info作为示例，且示例中的请求串不可直接复制访问）

(1) 原始请求信息：
appkey：228bf094169a40a3bd188ba37ebe8723

HTTP请求方式：GET

请求的URI路径（不含HOST）：/v3/user/get_info

请求参数：openid=11111111111111111&openkey=2222222222222222&appid=123456&pf=qzone&format=json&userip=112.90.139.30


(2) 下面开始构造源串：
第1步：将请求的URI路径进行URL编码，得到： %2Fv3%2Fuser%2Fget_info

第2步：将除“sig”外的所有参数按key进行字典升序排列，排列结果为：appid，format，openid，openkey，pf，userip

第3步：将第2步中排序后的参数(key=value)用&拼接起来：
appid=123456&format=json&openid=11111111111111111&openkey=2222222222222222&pf=qzone&userip=112.90.139.30
然后进行URL编码（ 编码时请关注URL编码注意事项，否则容易导致后面签名不能通过验证），编码结果为：
appid%3D123456%26format%3Djson%26openid%3D11111111111111111%26openkey%3D2222222222222222%26pf%3Dqzone%26
userip%3D112.90.139.30


第4步：将HTTP请求方式，第1步以及第3步中的到的字符串用&拼接起来，得到源串：
GET&%2Fv3%2Fuser%2Fget_info&appid%3D123456%26format%3Djson%26openid%3D11111111111111111%26
openkey%3D2222222222222222%26pf%3Dqzone%26userip%3D112.90.139.30

2. Step 2. 构造密钥
   得到密钥的方式：在应用的appkey末尾加上一个字节的“&”，即appkey&，例如：

1228bf094169a40a3bd188ba37ebe8723&
3. Step 3. 生成签名值
(1) 使用HMAC-SHA1加密算法，使用Step2中得到的密钥对Step1中得到的源串加密。
（注：一般程序语言中会内置HMAC-SHA1加密算法的函数，例如PHP5.1.2之后的版本可直接调用hash_hmac函数。）

(2) 然后将加密后的字符串经过Base64编码。
（注：一般程序语言中会内置Base64编码函数，例如PHP中可直接调用 base64_encode() 函数。）

(3) 得到的签名值结果如下：
1FdJkiDYwMj5Aj1UG2RUPc83iokk=