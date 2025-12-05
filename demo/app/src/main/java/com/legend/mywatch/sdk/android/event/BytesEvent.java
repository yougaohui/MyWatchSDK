package com.legend.mywatch.sdk.android.event;

import java.util.UUID;

public class BytesEvent {
    private byte[] bytes;
    private UUID uuid;

    public BytesEvent(byte[] bytes, UUID uuid) {
        this.uuid = uuid;
        this.bytes = bytes;
    }

    public UUID getUuid() {
        return uuid;
    }

    public byte[] getBytes() {
        return bytes;
    }
}
