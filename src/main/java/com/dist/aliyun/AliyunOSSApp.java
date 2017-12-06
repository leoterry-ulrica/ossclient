package com.dist.aliyun;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;

/**
 * aliyun oss
 * @date 2017.12.06
 * @author weifj
 *
 */
public class AliyunOSSApp
{
    /**
     * 需要这个endpoint地址，跟你购买时选择的数据中心有关系
     */
    private static String ENDPOINT = "http://oss-cn-<DataCenter>.aliyuncs.com";
    private static String ACCESS_KEY_ID = "<AccessKeyId>";
    private static String ACCESS_KEY_SECRET = "<AccessKeySecret>";

    public static void main( String[] args ) {
        System.out.println( "aliyun oss start..." );
        OSSClient client = null;
        try {
            // 创建OSSClient实例
            client = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            if (null == client) {
                throw new Exception("aliyun oss client init fail...");
            }
            boolean exist = client.doesBucketExist("weifj-1512559237591");
            if (exist) {
                System.out.println("bucket name exist : weifj-1512559237591");
            } else {
                System.out.println("bucket name not exist : weifj-1512559237591");
            }
            Bucket bucket = client.createBucket("weifj-" + System.currentTimeMillis());
            if (bucket != null) {
                System.out.println("bucket name : " + bucket.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭client
            if (client != null) {
                client.shutdown();
            }
        }
    }
}
