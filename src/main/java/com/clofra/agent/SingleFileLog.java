package com.clofra.agent;

import com.clofra.agent.interfaces.ILog;

import java.io.RandomAccessFile;
import java.nio.charset.IllegalCharsetNameException;

public class SingleFileLog  implements ILog {
    private String logFile;
    private Integer blockSize;
    private Long filePosition;
    private Long messageStartTime;
    private Long messageEndTime;



    public SingleFileLog(String logFile, Integer blockSize) {
        this.logFile = logFile;
        this.blockSize = blockSize;
        try
        {
            RandomAccessFile file = new RandomAccessFile(logFile, "r");
            filePosition = file.length();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        this.messageEndTime = System.currentTimeMillis();
        this.messageStartTime = System.currentTimeMillis();

    }

    @Override
    public String GetLog() {
        String message = "";
        try(RandomAccessFile in = new RandomAccessFile(logFile, "r")) {
            in.seek(filePosition);
            byte[] bbuf = new byte[blockSize];
            int len;
            while ((len = in.read(bbuf)) != -1)
            {
                message = new String(bbuf);
                if(len<blockSize)
                    message = message.substring(0,len);
                filePosition += len;
                System.out.println("in create log message"+message);
            }
            in.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        //TODO: might need to use lock here
        messageStartTime = messageEndTime;
        messageEndTime = System.currentTimeMillis();
        return message;
    }

    public Long getStartTimestamp()
    {
        return messageStartTime;
    }

    public Long getEndTimestamp()
    {
        return messageEndTime;
    }

}
