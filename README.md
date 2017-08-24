# project-cache
cache solution


# project-cache:缓存子系统

com.cache.client：客户端调用
com.cache.common：公共部分
com.cache.localcache：本地缓存
com.cache.memcache：memcache缓存
com.cache.redis：redis缓存
com.cache.util：工具类

conf/cache.properties：配置



# 依赖的包：
log4j: 
	commons-logging-1.1.1.jar
	log4j-1.2.16.jar
	slf4j-api-1.5.8.jar
	slf4j-log4j12-1.5.8.jar
	commons-logging.properties
memecached:
	junit-4.1.jar
	xmemcached-1.2.6.2.jar
redis:
	commons-pool2-2.4.2.jar
	jedis-2.9.0.jar

# 关注点：
	1.以什么数据结构存在，确保存取高效、内存最优
	2.缓存过期怎么处理
	3.当大用户量访问时，如何确保并发安全