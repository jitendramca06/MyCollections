package com.questions.java.designpattern.behavorial.Iterator;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public interface ChannelCollection {
    public void addChannel(Channel c);

    public void removeChannel(Channel c);

    public ChannelIterator iterator(ChannelTypeEnum type);
}
