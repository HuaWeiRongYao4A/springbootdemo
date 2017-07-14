package com.example.demo.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCache {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	public void put(String key, Object value) {
		final String keyf = key; 
		final Object valuef = value;
		
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = keyf.getBytes();
				byte[] valueb = toByteArray(valuef);
				connection.set(keyb, valueb);
				return 1L;
			}
		});
	}

	public void put(String key, Object value, long expire, TimeUnit timeUnit) {
		final String keyf = key;
		final Object valuef = value;
		final long expiref = TimeoutUtils.toSeconds(expire, timeUnit);

		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = keyf.getBytes();
				byte[] valueb = toByteArray(valuef);
				connection.set(keyb, valueb);
				
				if (expiref > 0) {
					connection.expire(keyb, expiref);
				}
				return 1L;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		Object object;
        final String keyf = key;
        object = redisTemplate.execute(new RedisCallback<Object>() {
        	public Object doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keyByte = keyf.getBytes();  
                byte[] value = connection.get(keyByte);  
                if (value == null) {  
                    return null;  
                }  
                return toObject(value);  
  
            }  
        });  
        return (T) object;
	}

	public void expire(String key, long expire, TimeUnit timeUnit) {
		final String keyf = key;
		final long expiref = TimeoutUtils.toSeconds(expire, timeUnit);
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] keyByte = keyf.getBytes(); 
				connection.expire(keyByte, expiref);
				return null;
			}
		});
	}

	public void del(String key) {
		final String keyf = key;  
        redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(keyf.getBytes());  
            }
        });
	}

	public void clear() {
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				  connection.flushDb();
				return null;
			}
		});
	}
	
	/**
	 * 描述 : <Object转byte[]>.
	 * 
	 * @param obj
	 * @return
	 */
	private byte[] toByteArray(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
			oos.close();
			bos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return bytes;
	}

	/**
	 * 描述 : <byte[]转Object>.
	 * 
	 * @param bytes
	 * @return
	 */
	private Object toObject(byte[] bytes) {
		Object obj = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bis);
			obj = ois.readObject();
			ois.close();
			bis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return obj;
	}

}
