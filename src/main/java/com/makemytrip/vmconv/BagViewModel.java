package com.makemytrip.vmconv;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * AggregateViewModel
 */
public class BagViewModel implements ViewModel {
    private String view = "AGGREGATE_VIEW";
    private Map<String, Object> data = new HashMap<String, Object>();
    private Map<String, Object> events = new HashMap<String, Object>();

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getEvents() {
        return events;
    }

    public void setEvents(Map<String, Object> events) {
        this.events = events;
    }

    public String toJson() {
        return new Gson().toJson(this, BagViewModel.class);
    }
}
