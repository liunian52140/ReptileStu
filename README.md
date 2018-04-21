# ReptileStu
 这是一个fun.migu.cn 网站的小爬虫 <br>
 bean数据存放类<br>
 servic 接口<br>
 util 工具<br>

 用到了 httpclient最新版 和 jsoup

### 技术不多 主要是分析。<br>

 1：通过分析 我们知道了 网站的登陆用的是sha1算法 所以在utils下面有个 EncryptShaOne方法 用于sha1加密 然乎登陆。<br>
 2：登陆之后返回的是cookie 在web中获取到cookie就是登陆成功了<br>
 3：书籍信息用的是 Util下面的jsoup解析 当然，并未插录数据库。<br>
 4：支付信息 经过分析 第三方支付是这样的 客户端请求一个XMLRequest 服务端获取数据 并返回一个主键（MD5主键）这里用到了xml推送数据 笔者写了个组织报文的工具但并未详细分析。


### 未实现的<br>
<br> 本人对话费支付进行了详细的分析，但是并未获取到有用的信息。解码是不可能的，这辈子都不可能的。
