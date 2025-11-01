package com.kie;

import java.util.Collections;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

/**
 * A WorkItemHandler implementation that prints "Hello World"
 * (or a custom message if provided as parameter).
 */
public class HelloWorldService implements WorkItemHandler {

  public void print()
    {
         System.out.println("welcome to print method");
    }
    
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        // get input parameter from the BPMN process (optional)
        Object msg = workItem.getParameter("message");

        if (msg == null) {
            msg = "Hello, World!";
        }

        // Print to console
        System.out.println("[HelloWorldService] " + msg.toString());

        // Complete the work item (no outputs in this simple example)
        manager.completeWorkItem(workItem.getId(), Collections.emptyMap());
    }

    
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        // no special handling on abort
    }
}






