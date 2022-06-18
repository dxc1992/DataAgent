package com.clofra.agent;


public class AgentConfiguration {

    private static String token;
    private static String topicName;

    private static String serviceName;
    private static String instanceName;
    private static String tenantName;
    private static String logFileLocation;
    private static String logType;
    private static Integer collectionInterval;
    private static Integer blockSize;

    private AgentConfiguration() {

    }

    public static String changeConfig(String key, String value)
    {
        key = key.toLowerCase();

        if(key.equals("token"))
            token = value;
        else if(key.equals("topicname"))
            topicName = value;
        else if(key.equals("servicename"))
            serviceName = value;
        else if(key.equals("instancename"))
            instanceName = value;
        else if(key.equals("tenantname"))
            tenantName = value;
        else if(key.equals("logfilelocation"))
            logFileLocation = value;
        else if(key.equals("logtype"))
            logType = value;
        else if(key.equals("collectioninterval"))
            collectionInterval = Integer.parseInt(value);
        else if(key.equals("blocksize"))
            blockSize = Integer.parseInt(value);
        else
            return "Key not found";

        return "Success";
    }

    public static String getConfig(String key)
    {
        key = key.toLowerCase();

        if(key.equals("token"))
            return token;
        else if(key.equals("topicname"))
            return topicName;
        else if(key.equals("servicename"))
            return serviceName;
        else if(key.equals("instancename"))
            return instanceName;
        else if(key.equals("tenantname"))
            return tenantName;
        else if(key.equals("logfilelocation"))
            return logFileLocation;
        else if(key.equals("logtype"))
            return logType;
        else if(key.equals("collectioninterval"))
            return collectionInterval.toString();
        else if (key.equals("blocksize"))
            return blockSize.toString();
        else
            return "Key not found";
    }


    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        AgentConfiguration.token = token;
    }

    public static String getTopicName() {
        return topicName;
    }

    public static void setTopicName(String topicName) {
        AgentConfiguration.topicName = topicName;
    }

    public static String getServiceName() {
        return serviceName;
    }

    public static void setServiceName(String serviceName) {
        AgentConfiguration.serviceName = serviceName;
    }

    public static String getInstanceName() {
        return instanceName;
    }

    public static void setInstanceName(String instanceName) {
        AgentConfiguration.instanceName = instanceName;
    }

    public static String getTenantName() {
        return tenantName;
    }

    public static void setTenantName(String tenantName) {
        AgentConfiguration.tenantName = tenantName;
    }

    public static String getLogFileLocation() {
        return logFileLocation;
    }

    public static void setLogFileLocation(String logFileLocation) {
        AgentConfiguration.logFileLocation = logFileLocation;
    }

    public static String getLogType() {
        return logType;
    }

    public static void setLogType(String logType) {
        AgentConfiguration.logType = logType;
    }

    public static Integer getCollectionInterval() {
        return 10000;
    }

    public static void setCollectionInterval(Integer collectionInterval) {
        AgentConfiguration.collectionInterval = collectionInterval;
    }

    public static Integer getBlockSize() {
        return 1024;
    }

    public static void setBlockSize(Integer blockSize) {
        AgentConfiguration.blockSize = blockSize;
    }

    public static void setDefaultConfiguration() {
        AgentConfiguration.setToken("test-token");
        AgentConfiguration.setTopicName("test-token");
        AgentConfiguration.setCollectionInterval(2000);
        AgentConfiguration.setLogFileLocation("C:\\Users\\abhil\\Downloads\\GremlinExecutionProfiles.txt");
    }
}
