package com.unexpected.ant.model;

/**
 * All objects which are to be scheduled must implement this interface. The scheduler invokes the action method and
 * passes the tick count elapsed from the start of the process.
 */
public interface Dynamic {
    /**
     * This method gets invoked by the scheduler
     *
     * @param tickCount Tick count elapsed from the start of the process
     */
    void action(long tickCount);
}
