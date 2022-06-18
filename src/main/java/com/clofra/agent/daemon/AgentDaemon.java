package com.clofra.agent.daemon;

import com.clofra.agent.AgentConfiguration;
import com.clofra.agent.KafkaTopicAgent;
import com.clofra.agent.SingleFileLog;
import com.clofra.agent.api.ConfigurationResource;
import com.clofra.agent.interfaces.IAgent;
import com.clofra.agent.interfaces.ILog;
import com.clofra.agent.interfaces.IMessage;

public class AgentDaemon {

    private static void setConfiguration(String[] args) {
        //TODO: call getter setter to populate AgentConfiguration variables
        AgentConfiguration.setDefaultConfiguration();
    }

    public static void main(String[] args){
        setConfiguration(args);
        ConfigurationResource.main(args);
        ILog logExtract = new SingleFileLog(AgentConfiguration.getLogFileLocation(), AgentConfiguration.getBlockSize());
        IAgent agent = new KafkaTopicAgent(logExtract);
        AgentRunner agentRunner = new AgentRunner(agent);
        Thread agentThread = new Thread(agentRunner);
        agentThread.start();
    }


    static class AgentRunner implements Runnable {

        IAgent agent;
        public AgentRunner(IAgent agent) {
            this.agent = agent;
        }

        public void run() {
            agent.RegisterAgent();
            while(true)
            {
                try {
                    Thread.sleep(AgentConfiguration.getCollectionInterval());
//                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                IMessage message = agent.CreateLogMessage();
                agent.SendLogMessage(message);
            }
        }
    }


}
