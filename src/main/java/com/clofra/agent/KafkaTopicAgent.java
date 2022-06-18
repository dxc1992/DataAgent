package com.clofra.agent;

import com.clofra.agent.interfaces.IAgent;
import com.clofra.agent.interfaces.ILog;
import com.clofra.agent.interfaces.IMessage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Arrays;
import java.io.RandomAccessFile;

// Assumption is file will be append only
public class KafkaTopicAgent implements IAgent {
    ILog logExtract;
    static long filePosition;
    //TODO: Add it in config
    static int blockSize = 1024;
    public KafkaTopicAgent(ILog logExtract) {
        this.logExtract = logExtract;
    }

    @Override
    public boolean RegisterAgent() {
        return false;
    }

    @Override
    public IMessage CreateLogMessage() {
        Message message = new Message();
        message.setLogMessage(logExtract.GetLog());
        message.setStartTimestamp(logExtract.getStartTimestamp());
        message.setEndTimestamp(logExtract.getEndTimestamp());
        return (IMessage) message;
    }

    @Override
    public boolean SendLogMessage(IMessage message) {
        System.out.println("In sendlog message:"+message.getLogMessage());
        
        return true;
    }
}
