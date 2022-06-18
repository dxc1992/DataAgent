package com.clofra.agent.interfaces;

public interface IAgent {
    boolean RegisterAgent();
    IMessage CreateLogMessage();
    boolean SendLogMessage(IMessage message);
}
