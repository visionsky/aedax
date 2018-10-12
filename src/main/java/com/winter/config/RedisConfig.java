package com.winter.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.annotation.EnableCaching;

import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
@EnableCaching
//@PropertySource("classpath:config/redis.properties")

public class RedisConfig extends CachingConfigurerSupport {
/*
	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.pool.max-idle}")
	private int maxIdle;

	@Value("${spring.redis.pool.max-wait}")
	private long maxWaitMillis;

//    @Value("${spring.redis.password}")
//    private String password;
@Value("${redis.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;

    @Value("${redis.numTestsPerEvictionRun}")
    private Integer numTestsPerEvictionRun;

    @Value("${redis.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${redis.testWhileIdle}")
    private boolean testWhileIdle;


    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

    @Value("${spring.redis.cluster.max-redirects}")
    private Integer mmaxRedirectsac;

	@Bean
	public JedisPool redisPoolFactory() {
		System.out.println("JedisPool注入成功！！");
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		//本地redis未设置密码，所以第五个参数password不传
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
		return jedisPool;
	}
	//JedisPoolConfig 连接池
	    @ Bean
public JedisPoolConfig jedisPoolConfig() {
	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	// 最大空闲数
	jedisPoolConfig.setMaxIdle(maxIdle);
	// 连接池的最大数据库连接数
	jedisPoolConfig.setMaxTotal(maxTotal);
	// 最大建立连接等待时间
	jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
	// 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
	jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	// 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
	jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
	// 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
	jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
	// 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
	jedisPoolConfig.setTestOnBorrow(testOnBorrow);
	// 在空闲时检查有效性, 默认false
	jedisPoolConfig.setTestWhileIdle(testWhileIdle);
	return jedisPoolConfig;
}
	//	 * 单机版配置

	@Bean
	public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
		JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
		//连接池
		JedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		//IP地址
		JedisConnectionFactory.setHostName("192.168.177.128");
		//端口号
		JedisConnectionFactory.setPort(6379);
		//如果Redis设置有密码
		//JedisConnectionFactory.setPassword(password);
		//客户端超时时间单位是毫秒
		JedisConnectionFactory.setTimeout(5000);
		return JedisConnectionFactory;
	}
 //    * Redis集群的配置

@Bean
public RedisClusterConfiguration redisClusterConfiguration(){
	RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
	//Set<RedisNode> clusterNodes
	String[] serverArray = clusterNodes.split(",");

	Set<RedisNode> nodes = new HashSet<RedisNode>();

	for(String ipPort:serverArray){
		String[] ipAndPort = ipPort.split(":");
		nodes.add(new RedisNode(ipAndPort[0].trim(),Integer.valueOf(ipAndPort[1])));
	}

	redisClusterConfiguration.setClusterNodes(nodes);
	redisClusterConfiguration.setMaxRedirects(mmaxRedirectsac);

	return redisClusterConfiguration;
}
	/**	 * 配置工厂

	@Bean
	public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig jedisPoolConfig,RedisClusterConfiguration redisClusterConfiguration){
		JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration,jedisPoolConfig);

		return JedisConnectionFactory;
	}


*/

	// 自定义缓存key生成策略
	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, java.lang.reflect.Method method, Object... params) {
				StringBuffer sb = new StringBuffer();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

	// 缓存管理器
	@Bean
	public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		// 设置缓存过期时间
		cacheManager.setDefaultExpiration(10000);
		return cacheManager;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		setSerializer(template);// 设置序列化工具
		template.afterPropertiesSet();
		return template;
	}

	private void setSerializer(StringRedisTemplate template) {
		@SuppressWarnings({ "rawtypes", "unchecked" })
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
	}
}
