# **`comspringboot`**
SpringBoot企业级项目demo

    本博客系统分为前台和后台两个大模块， 其中后台为博客管理页面， 前台为用户界面。
    (1) 后台主要包括以下几个功能：
        登陆、注册功能：用户可以注册，注册时用户输入注册信息，同时向数据库中保
    存用户注册信息。进入后台时要登录，输入用户名和密码。
        日志管理：用户可以发表日志，对日志信息查看、修改和删除。日志信息包括标
    题、发表时间、所属类型、日志描述信息等。
        日志类型管理：用户可以添加、删除、修改日志类型。
        好友管理功能：用户可以添加、删除、查看好友，访问好友的博客
        相册管理：上传图片到自己的相册，删除相册中的照片，查看上传的照片。
        留言管理：用户可以对访问者给自己的留言查看和删除。
    (2) 前台主要包括以下功能：
        日志查看功能： 访问者可以查看博主的日志， 并可以按照日志分类来查看。 还可
    以对博主的日志发表评论。
        相册查看功能：查看博主上传的图片。
        留言板功能：给博主留言。
        查看博主的好友：查看博主的好友。
    3 系统的业务需求及流程
        注册用户可以注册、登录本系统，对文章、相册、好友、留言等进行管理，其中包括对各个模块的信息的增、删、改、查操作。
     网友可以访问博主的博客，浏览博主的文章、相册、好友等信息，还可以对文章
    进行评论，给博主留言。




>数据库文件已经上传！ 
<br>使用的数据库为MySql
<br>2019/2/23 


接口实现情况
<hr></hr>
(一)用户模块<br>




接口名称|接口地址 | 请求方法|提供参数
----------|---------| -------------|-------------------------
验证登录|http://localhost8080:/user/loginVerify| POST|username,password
注册接口|http://localhost8080：/user/registers|POST| username,password,usersex,usermail,userqq
 -----------|目前就这两个为post接口其他的Get接口看Controller层可以查看




(二)文章类型模块<br>




接口名称|接口地址 | 请求方法|提供参数
----------|---------| -------------|-------------------------
添加分类|http://localhost8080:/articleType/addType| POST|typeName,typeInfo
删除分类|http://localhost8080:/articleType/updateType| POST|int articleTypeId
查询分类|http://localhost8080:/articleType/deleteType| POST|int articleTypeId
更改分类|http://localhost8080:/articleType/selectOneType| POST|int typeId, String typeName, String typeInfo
 -----------|目前就这一个为post接口其他的Get接口看Controller层可以查看



(三)文章模块<br>




接口名称|接口地址 | 请求方法|提供参数
----------|---------| -------------|-------------------------
添加文章|http://localhost8080:/article/addArticle| POST|int typeId,String articleTitle,String articleContent,String articlesendTime,String articleCreate,String articleInfo,int articleStatus,String articleFlag,String articleKeyword,int articleOpenness,String articleImg
查询文章|http://localhost8080:/article/show|GET|id(为用户的id，用户必须存在，且该用户存在日志) 
删除文章|http://localhost8080:/article/delete|Post|userId,articleId 
更新文章|http://localhost:8080:/article/updateArticle|Post|int primarykey,int articleTypeId,String articleTitle, String articleContent,String articleSendTime, String  articleCreate, String articleInfo
 -----------|Id类型参数为int,为对应的id，剩下的参数全为String类型
 
 
 
 
 (四)好友模块<br>
 
 
 
 
 接口名称|接口地址 | 请求方法|提供参数
 ----------|---------| -------------|-------------------------
 添加好友|http://localhost8080:/friend/addFriend| Post|int userId,String friendName,String friendSex,String friendQq,String friendBlog 
 删除好友|http://localhost8080:/friend/delete|Post|int friendId
 更新好友|http://localhost8080:/friend/update|Post|int friendId,int userId,String friendName,String friendSex,String friendQq,String friendBlog 
 查询好友|http://localhost:8080:/friend/find|Post|int friendId

 
 
 
 
 
 (五)留言模块<br>
  
  
  
  
  接口名称|接口地址 | 请求方法|提供参数
  ----------|---------| -------------|-------------------------
  添加留言|http://localhost8080:/message/addMessage| Post|int userId,String messageTitle,String messageAuthor,String messageContent,String messageTime
  删除留言|http://localhost8080:/message/delete|Post|int messageId
  查询留言|http://localhost:8080:/message/findOne|Post|int messageId
  查询某用户所有留言|http://localhost:8080:/message/findAll|Post|int userId
  
  
  
  
  (六)相册模块<br>
  
  
  
  
  
  
  
  接口名称|接口地址 | 请求方法|提供参数
    ----------|---------| -------------|-------------------------
  添加图片|http://localhost8080:/photo/addPhoto| Post|int userId,String photoName, String photoAddr,String photoInfo, String photoTime
  删除图片|http://localhost8080:/photo/delete|Post|int photoId
  查询图片|http://localhost:8080:/photo/findOne|Post|int photoId
  查询某用户所有图片|http://localhost:8080:/photo/findAll|Post|int userId
  
  
  (七)评论模块
  
  
  
   接口名称|接口地址 | 请求方法|提供参数
      ----------|---------| -------------|-------------------------
    添加评论|http://localhost8080:/comment/addComment| Post|int articleId,String reviewAuthor,String reviewContent
    删除评论|http://localhost8080:/comment/delete|Post|int commentId
    查询评论|http://localhost:8080:/comment/findOne|Post|int commentId
    查询某文章所有评论|http://localhost:8080:/comment/findAll|Post|int articleId

    



>结合前端<br>


从网上下了个博客的网页模板，娘的，渲染css的问题竟然消耗了我两个多小时，度娘真的屎坑，看来得多用Google。
第一可能是路径问题，第二就是，thymeleaf的坑，映入外部变量竟然要属性顺序，真的坑煞我也！！！不过最后总算解决了。




form有个onSubmit()方法，只有验证通过的时候，才能提交表单，否则不能提交表单！