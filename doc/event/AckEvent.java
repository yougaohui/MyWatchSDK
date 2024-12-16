package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 每次发送指令到设备端，设备端收到指令后都会回复对应的ack，用于判断数据是否成功
 */
public class AckEvent extends BaseEvent {
    private int command;//大key;
    private int commandKey;//小key，用于区分不同指令
    private boolean isSuccess;//true = 指令数据发送成功

    public AckEvent(int command, int commandKey, boolean isSuccess) {
        this.command = command;
        this.commandKey = commandKey;
        this.isSuccess = isSuccess;
    }

    public int getCommand() {
        return command;
    }

    public int getCommandKey() {
        return commandKey;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getMsgWhat() {
        return EventManager.getMsgWhat(command, commandKey);
    }

    /**
     * 是否时当前指令的ack
     *
     * @param commandBytes
     * @return true 表示是当前指令的ack
     */
    public boolean isCurrentAck(byte[] commandBytes) {
        if (commandBytes == null || commandBytes.length < 6) {
            return false;
        }
        return command == commandBytes[3] && commandKey == commandBytes[5];
    }
}
