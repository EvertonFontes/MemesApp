package com.EFYSoftware;

public class Flip {
    private boolean success;
    private data data;

    public Flip() { }

    public Flip(boolean success, data data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public data getData() {
        return data;
    }

    public void setData(data data) {
        this.data = data;
    }
}
