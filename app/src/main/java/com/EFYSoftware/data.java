package com.EFYSoftware;

import java.util.List;

public class data {

    private List<Memes> memes;

    public data() { }

    public data(List<Memes> memes) {
        this.memes = memes;
    }

    public List<Memes> getMemes() {
        return memes;
    }

    public void setMemes(List<Memes> memes) {
        this.memes = memes;
    }
}
